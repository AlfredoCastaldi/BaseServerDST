package com.Dst.serverBase.dto.dettagliDto;

import com.Dst.serverBase.entities.Ordine;
import com.Dst.serverBase.entities.Prodotto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class DettaglioOrdineResponseDTO {

    private Integer quantita;
    private Double prezzoTotale;
    private Ordine ordine;
    private Prodotto prodotto;
}
