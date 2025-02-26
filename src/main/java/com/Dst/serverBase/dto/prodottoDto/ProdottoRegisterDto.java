package com.Dst.serverBase.dto.prodottoDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdottoRegisterDto {

    private String nome;
    private Double prezzo;
}
