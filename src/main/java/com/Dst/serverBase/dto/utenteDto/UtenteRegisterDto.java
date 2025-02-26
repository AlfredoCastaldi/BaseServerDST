package com.Dst.serverBase.dto.utenteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UtenteRegisterDto {

    private String nome;

    private String email;
}
