package com.Dst.serverBase.dto.ordineDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrdineUpdateDTO {

    private LocalDate data;
    private String stato; // IN_ATTESA, SPEDITO, CONSEGNATO
    private Long user_id;

}
