package com.Dst.serverBase.service;

import com.Dst.serverBase.dto.dettagliDto.DettagliRegisterDto;
import com.Dst.serverBase.entities.DettaglioOrdine;
import com.Dst.serverBase.repositories.DettaglioOrdineRepo;
import com.Dst.serverBase.repositories.OrdineRepo;
import com.Dst.serverBase.repositories.ProdottoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DettagliOrdineService {

    @Autowired
    DettaglioOrdineRepo dettaglioOrdineRepo;

    @Autowired
    ProdottoRepo prodottoRepo;

    @Autowired
    OrdineRepo ordineRepo;

    public void insertNewDettagli(DettagliRegisterDto dto){
        dettaglioOrdineRepo.save(DettaglioOrdine.builder()
                        .prodotto(prodottoRepo.findById(dto.getProdotto_id()).get())
                        .ordine(ordineRepo.findById(dto.getOrdine_id()).get())
                        .quantita(dto.getQuantita())
                .build());
    }
}
