package com.Dst.serverBase.dto.ordineDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CarrelloDTO {

    String nomeUtente;
    String emailUtente;
    Double totale;
}
