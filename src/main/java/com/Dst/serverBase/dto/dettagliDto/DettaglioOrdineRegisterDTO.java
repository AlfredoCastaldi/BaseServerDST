package com.Dst.serverBase.dto.dettagliDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DettaglioOrdineRegisterDTO {

    private Integer quantita;

    private Long prodotto_id;
}
