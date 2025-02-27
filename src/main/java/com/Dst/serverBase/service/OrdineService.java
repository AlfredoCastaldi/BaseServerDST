package com.Dst.serverBase.service;

import com.Dst.serverBase.dto.dettagliDto.DettaglioOrdineRegisterDTO;
import com.Dst.serverBase.dto.ordineDto.OrdineMapperDTO;
import com.Dst.serverBase.dto.ordineDto.OrdineResponseDTO;
import com.Dst.serverBase.entities.DettaglioOrdine;
import com.Dst.serverBase.entities.Ordine;
import com.Dst.serverBase.repositories.OrdineRepo;
import com.Dst.serverBase.repositories.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class OrdineService {

    @Autowired
    OrdineRepo ordineRepo;
    @Autowired
    UtenteRepo utenteRepo;
    @Autowired
    DettagliOrdineService dettagliOrdineService;

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

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

    public List<OrdineResponseDTO> getAllOrders(){
        return ordineRepo.findAll().stream().map(OrdineMapperDTO::fromEntityToDto).toList();
    }

    public Optional<OrdineResponseDTO> updateOrder(Long order_id, String stato){
        Ordine oldOrdine = ordineRepo.findById(order_id).get();
        oldOrdine.setStato(stato);
        return Optional.of(ordineRepo.save(oldOrdine)).map(OrdineMapperDTO::fromEntityToDto);

    }
}
