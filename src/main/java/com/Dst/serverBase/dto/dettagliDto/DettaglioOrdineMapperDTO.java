package com.Dst.serverBase.dto.dettagliDto;

import com.Dst.serverBase.entities.DettaglioOrdine;
import com.Dst.serverBase.entities.Ordine;
import com.Dst.serverBase.entities.Prodotto;
import com.Dst.serverBase.repositories.OrdineRepo;
import com.Dst.serverBase.repositories.ProdottoRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DettaglioOrdineMapperDTO {

    static ProdottoRepo staticProdottoRepo;

    static OrdineRepo staticOrdineRepo;

    DettaglioOrdineMapperDTO(ProdottoRepo prodottoRepo, OrdineRepo ordineRepo) {
        staticProdottoRepo = prodottoRepo;
        staticOrdineRepo = ordineRepo;
    }

    public static DettaglioOrdine fromDtoToEntity(DettaglioOrdineRegisterDTO dto, Long ordine_id) {
        Prodotto prodotto = staticProdottoRepo.findById(dto.getProdotto_id()).get();
        Ordine ordine = staticOrdineRepo.findById(ordine_id).get();
        Double totaleCostoProdotti = prodotto.getPrezzo() * dto.getQuantita();
        return DettaglioOrdine.builder()
                .quantita(dto.getQuantita())
                .prodotto(prodotto)
                .ordine(ordine)
                .prezzoTotale(totaleCostoProdotti)
                .build();
    }

    public static DettaglioOrdineResponseDTO fromEntityToDto(DettaglioOrdine dettaglioOrdine) {
        Double totaleCostoProdotti = dettaglioOrdine.getProdotto().getPrezzo() * dettaglioOrdine.getQuantita();
        return DettaglioOrdineResponseDTO.builder()
                .ordine(dettaglioOrdine.getOrdine())
                .quantita(dettaglioOrdine.getQuantita())
                .prodotto(dettaglioOrdine.getProdotto())
                .prezzoTotale(totaleCostoProdotti)
                .build();

    }

    public static List<DettaglioOrdineResponseDTO> fromEntitiesToDtoList(List<DettaglioOrdine> orders) {
        return orders.stream().map(DettaglioOrdineMapperDTO::fromEntityToDto).toList();
    }
}
