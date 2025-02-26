package com.Dst.serverBase.service;

import com.Dst.serverBase.dto.prodottoDto.ProdottoDtoMapper;
import com.Dst.serverBase.dto.prodottoDto.ProdottoRegisterDto;
import com.Dst.serverBase.dto.prodottoDto.ProdottoResponseDto;
import com.Dst.serverBase.dto.utenteDto.UtenteMapper;
import com.Dst.serverBase.dto.utenteDto.UtenteResponseDto;
import com.Dst.serverBase.entities.Prodotto;
import com.Dst.serverBase.repositories.ProdottoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdottoService {


    @Autowired
    ProdottoRepo prodottoRepo;

    public Optional<ProdottoResponseDto> insertNewProdotto(ProdottoRegisterDto dto){
        return Optional.of(prodottoRepo.save(ProdottoDtoMapper.fromDtoToEntity(dto))).map(ProdottoDtoMapper::fromEntityToDto);
    }

    // READ
    public List<ProdottoResponseDto> findAllProdotto(){
        return prodottoRepo.findAll().stream().map(ProdottoDtoMapper::fromEntityToDto).toList();
    }
}
