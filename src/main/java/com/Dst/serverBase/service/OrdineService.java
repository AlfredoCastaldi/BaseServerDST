package com.Dst.serverBase.service;

import com.Dst.serverBase.dto.dettagliDto.DettaglioOrdineMapperDTO;
import com.Dst.serverBase.dto.dettagliDto.DettaglioOrdineRegisterDTO;
import com.Dst.serverBase.dto.ordineDto.CarrelloDTO;
import com.Dst.serverBase.dto.ordineDto.OrdineMapperDTO;
import com.Dst.serverBase.dto.ordineDto.OrdineResponseDTO;
import com.Dst.serverBase.dto.ordineDto.OrdineUpdateDTO;
import com.Dst.serverBase.entities.DettaglioOrdine;
import com.Dst.serverBase.entities.Ordine;
import com.Dst.serverBase.repositories.OrdineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrdineService {

    @Autowired
    OrdineRepo ordineRepo;
    @Autowired
    DettagliOrdineService dettagliOrdineService;


    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");


    public CarrelloDTO getCarrello(Long user_id){
        List<Ordine> ordini = ordineRepo.findAll();
        List<Ordine> correctOrders = ordini.stream().filter(ordine -> ordine.getUtente().getId() == user_id).toList();
        return OrdineMapperDTO.fromOrderListToCarrelloDTO(correctOrders, user_id);
    }
    public List<OrdineResponseDTO> getCarrelloByDate(LocalDate date1, LocalDate date2){
        List<Ordine> ordini = ordineRepo.findAll();
        return ordini.stream().filter(ordine -> ordine.getData().isAfter(date1) && ordine.getData().isBefore(date2))
                .map(OrdineMapperDTO::fromEntityToDto).toList();
    }

    // CREATE
    @Transactional
    public Optional<OrdineResponseDTO> insertNewOrder(Long utente_id, List<DettaglioOrdineRegisterDTO> detailsDto){

        Ordine ordine = OrdineMapperDTO.fromDtoToEntity(utente_id);
        Long newOrderId = ordineRepo.save(ordine).getId();
        ordine.setDettagli(getOrdineDetails(newOrderId, detailsDto));
        ordine.setTotale(getOrdineDetailsTotalCost(ordine.getDettagli()));
        return Optional.ofNullable(OrdineMapperDTO.fromEntityToDto(ordine));
    }

    private Double getOrdineDetailsTotalCost(List<DettaglioOrdine> details){
        return details.stream().mapToDouble(DettaglioOrdine::getPrezzoTotale).sum();
    }

    @Transactional
    private List<DettaglioOrdine> getOrdineDetails(Long ordine_id, List<DettaglioOrdineRegisterDTO> dto){
        return dto.stream().map(
                (valueDto)->{
                    return dettagliOrdineService.insertNewDettagli(valueDto, ordine_id);
                }
        ).toList();
    }

    //READ
    public Optional<OrdineResponseDTO> getOrderById(Long ordine_id){
        return ordineRepo.findById(ordine_id).map(OrdineMapperDTO::fromEntityToDto);
    }

    public List<OrdineResponseDTO> getAllOrders(){
        return ordineRepo.findAll().stream().map(OrdineMapperDTO::fromEntityToDto).toList();
    }

    public Optional<OrdineResponseDTO> updateOrder(Long order_id, String stato){
        Ordine oldOrdine = ordineRepo.findById(order_id).get();
        oldOrdine.setStato(stato);
        return Optional.of(ordineRepo.save(oldOrdine)).map(OrdineMapperDTO::fromEntityToDto);

    }

    // UPDATE
    public Optional<OrdineResponseDTO> updateOrderById(Long id, OrdineUpdateDTO newOrderUpdate) {
        if (getOrderById(id).isPresent()) {
        Ordine ordine = OrdineMapperDTO.fromUpdateDtoToEntity(newOrderUpdate);
        Long oldRecordId = id;
        ordine.setId(oldRecordId);
        return Optional.of(ordineRepo.save(ordine)).map(OrdineMapperDTO::fromEntityToDto);
        } else {
            return Optional.empty();
        }
    }

    public Optional<OrdineResponseDTO> updateOrderDetailsById(Long id, List<DettaglioOrdineRegisterDTO> detailsDtoList ){
        if (getOrderById(id).isPresent()) {
            Ordine ordine = ordineRepo.findById(id).get();
            ordine.setId(id);
            ordine.setDettagli(getOrdineDetails(id, detailsDtoList));
            ordine.setTotale(getOrdineDetailsTotalCost(ordine.getDettagli()));
            return Optional.of(ordineRepo.save(ordine)).map(OrdineMapperDTO::fromEntityToDto);
        } else {
            return Optional.empty();
        }
    }

    private void findOneDetailFromOrderById(Long dettaglio_id, Ordine ordine, DettaglioOrdine newOrdine){
        for (DettaglioOrdine dettaglioOrdine : ordine.getDettagli()) {
            if (Objects.equals(dettaglioOrdine.getId(), dettaglio_id)){
                dettaglioOrdine = newOrdine;
            }
        }
    }

    public Optional<OrdineResponseDTO> updateSingleOrderDetailById(Long order_id, Long detail_id, DettaglioOrdineRegisterDTO newDettagli){
        if (getOrderById(order_id).isPresent()){
            Ordine ordine = ordineRepo.findById(order_id).get();
            ordine.setId(order_id);
            DettaglioOrdine dettaglioOrdine = dettagliOrdineService.dettaglioOrdineRepo.findById(detail_id).map(
                    (value) -> {
                        value.setId(detail_id);
                        DettaglioOrdineMapperDTO.fromDtoToEntity(newDettagli, order_id);
                        return value;
                    }
            ).get();
            findOneDetailFromOrderById(detail_id, ordine, dettaglioOrdine);
            return Optional.of(ordineRepo.save(ordine)).map(OrdineMapperDTO::fromEntityToDto);
        } else {
            return Optional.empty();
        }
    }
}
