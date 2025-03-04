package com.Dst.serverBase.service;

import com.Dst.serverBase.dto.dettagliDto.DettaglioOrdineMapperDTO;
import com.Dst.serverBase.dto.dettagliDto.DettaglioOrdineRegisterDTO;
import com.Dst.serverBase.dto.dettagliDto.DettaglioOrdineResponseDTO;
import com.Dst.serverBase.entities.DettaglioOrdine;
import com.Dst.serverBase.repositories.DettaglioOrdineRepo;
import com.Dst.serverBase.repositories.OrdineRepo;
import com.Dst.serverBase.repositories.ProdottoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DettagliOrdineService {

    @Autowired
    DettaglioOrdineRepo dettaglioOrdineRepo;
    @Autowired
    OrdineRepo ordineRepo;
    @Autowired
    ProdottoRepo prodottoRepo;


    public DettaglioOrdine insertNewDettagli(DettaglioOrdineRegisterDTO dto, Long ordine_id){
        return dettaglioOrdineRepo.save(DettaglioOrdineMapperDTO.fromDtoToEntity(dto, ordine_id));
    }
    public Optional<DettaglioOrdineResponseDTO> findDettaglioById(Long dettaglio_id){
        return dettaglioOrdineRepo.findById(dettaglio_id).map(DettaglioOrdineMapperDTO::fromEntityToDto);
    }


}
