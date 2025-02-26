package com.Dst.serverBase.dto.utenteDto;

import com.Dst.serverBase.entities.Utente;

import java.util.List;

public class UtenteMapper {


   public static Utente fromDtoToEntity(UtenteRegisterDto dto){
       return Utente.builder()
               .nome(dto.getNome())
               .email(dto.getEmail())
               .build();
   }
    public static UtenteResponseDto fromEntityToDto(Utente dto){
        return UtenteResponseDto.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .email(dto.getEmail())
                .build();
    }
    public static List<UtenteResponseDto> fromDtoToEntity(List<Utente> dto){
        return dto.stream().map(UtenteMapper::fromEntityToDto).toList();
    }
}
