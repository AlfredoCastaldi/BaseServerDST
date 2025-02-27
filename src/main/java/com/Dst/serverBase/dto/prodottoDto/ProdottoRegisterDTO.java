package com.Dst.serverBase.dto.prodottoDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdottoRegisterDTO {

    private String nome;
    private Double prezzo;
}
