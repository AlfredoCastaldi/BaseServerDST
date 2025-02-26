package com.Dst.serverBase.dto.prodottoDto;

import com.Dst.serverBase.dto.utenteDto.UtenteMapper;
import com.Dst.serverBase.dto.utenteDto.UtenteRegisterDto;
import com.Dst.serverBase.dto.utenteDto.UtenteResponseDto;
import com.Dst.serverBase.entities.Prodotto;
import com.Dst.serverBase.entities.Utente;

import java.util.List;

public class ProdottoDtoMapper {



    public static Prodotto fromDtoToEntity(ProdottoRegisterDto dto){
        return Prodotto.builder()
                .nome(dto.getNome())
                .prezzo(dto.getPrezzo())
                .build();
    }
    public static ProdottoResponseDto fromEntityToDto(Prodotto prodotto){
        return ProdottoResponseDto.builder()
                .id(prodotto.getId())
                .nome(prodotto.getNome())
                .prezzo(prodotto.getPrezzo())
                .build();
    }
    public static List<ProdottoResponseDto> fromDtoToEntity(List<Prodotto> dto){
        return dto.stream().map(ProdottoDtoMapper::fromEntityToDto).toList();
    }
}
