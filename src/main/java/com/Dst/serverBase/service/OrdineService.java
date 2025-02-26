package com.Dst.serverBase.service;

import com.Dst.serverBase.dto.dettagliDto.DettagliRegisterDto;
import com.Dst.serverBase.dto.ordineDto.OrdineDtoMapper;
import com.Dst.serverBase.dto.ordineDto.OrdineRegisterDto;
import com.Dst.serverBase.dto.ordineDto.OrdineResponseDto;
import com.Dst.serverBase.entities.DettaglioOrdine;
import com.Dst.serverBase.entities.Ordine;
import com.Dst.serverBase.repositories.OrdineRepo;
import com.Dst.serverBase.repositories.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
    public Ordine insertNewOrder(Long utente_id, List<DettagliRegisterDto> detailsDto){
        LocalDate date = LocalDate.now();
        Ordine ordine = Ordine.builder()
                .data(date)
                .utente(utenteRepo.findById(utente_id).get())
                .stato("IN ATTESA")
                .build();
        Long newOrderId = ordineRepo.save(ordine).getId();
        ordine.setDettagli(getOrdineDetails(newOrderId, detailsDto));
        ordine.setTotale(ordine.getDettagli().stream().mapToDouble(DettaglioOrdine::getPrezzoTotale).sum());
        return ordine;
    }

    @Transactional
    private List<DettaglioOrdine> getOrdineDetails(Long ordine_id, List<DettagliRegisterDto> dto){
        return dto.stream().map(
                (valueDto)->{
                    return dettagliOrdineService.insertNewDettagli(valueDto, ordine_id);
                }
        ).toList();
    }
}
