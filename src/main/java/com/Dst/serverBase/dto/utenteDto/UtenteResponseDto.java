package com.Dst.serverBase.dto.utenteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UtenteResponseDto {

    private Long id;

    private String nome;
    private String email;

}
