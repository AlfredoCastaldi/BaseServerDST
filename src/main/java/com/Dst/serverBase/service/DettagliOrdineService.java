package com.Dst.serverBase.service;

import com.Dst.serverBase.dto.dettagliDto.DettagliRegisterDto;
import com.Dst.serverBase.entities.DettaglioOrdine;
import com.Dst.serverBase.entities.Prodotto;
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
    OrdineRepo ordineRepo;
    @Autowired
    ProdottoRepo prodottoRepo;


    public DettaglioOrdine insertNewDettagli(DettagliRegisterDto dto, Long ordine_id){
        Prodotto prodotto = prodottoRepo.findById(dto.getProdotto_id()).get();
        Double prezzoTotale = prodotto.getPrezzo() * dto.getQuantita();
        DettaglioOrdine ordine = DettaglioOrdine.builder()
                .ordine(ordineRepo.findById(ordine_id).get())
                .prodotto(prodottoRepo.findById(dto.getProdotto_id()).get())
                .prezzoTotale(prezzoTotale)
                .quantita(dto.getQuantita())
                .build();

        return ordine;
    }
}
