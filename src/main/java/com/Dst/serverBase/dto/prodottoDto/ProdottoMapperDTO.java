package com.Dst.serverBase.dto.prodottoDto;

import com.Dst.serverBase.entities.Prodotto;

import java.util.List;

public class ProdottoMapperDTO {



    public static Prodotto fromDtoToEntity(ProdottoRegisterDTO dto){
        return Prodotto.builder()
                .nome(dto.getNome())
                .prezzo(dto.getPrezzo())
                .build();
    }
    public static ProdottoResponseDTO fromEntityToDto(Prodotto prodotto){
        return ProdottoResponseDTO.builder()
                .id(prodotto.getId())
                .nome(prodotto.getNome())
                .prezzo(prodotto.getPrezzo())
                .build();
    }
    public static List<ProdottoResponseDTO> fromDtoToEntity(List<Prodotto> dto){
        return dto.stream().map(ProdottoMapperDTO::fromEntityToDto).toList();
    }
}
