package com.Dst.serverBase.dto.utenteDto;

import com.Dst.serverBase.entities.Utente;

import java.util.List;

public class UtenteMapperDTO {


   public static Utente fromDtoToEntity(UtenteRegisterDTO dto){
       return Utente.builder()
               .nome(dto.getNome())
               .email(dto.getEmail())
               .build();
   }
    public static UtenteResponseDTO fromEntityToDto(Utente dto){
        return UtenteResponseDTO.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .email(dto.getEmail())
                .build();
    }
    public static List<UtenteResponseDTO> fromEntitiesListToDTOList(List<Utente> dto){
        return dto.stream().map(UtenteMapperDTO::fromEntityToDto).toList();
    }
}
