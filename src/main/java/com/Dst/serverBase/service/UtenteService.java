package com.Dst.serverBase.service;

import com.Dst.serverBase.dto.utenteDto.UtenteMapper;
import com.Dst.serverBase.dto.utenteDto.UtenteRegisterDto;
import com.Dst.serverBase.dto.utenteDto.UtenteResponseDto;
import com.Dst.serverBase.repositories.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UtenteService {

    @Autowired
    UtenteRepo utenteRepo;

    //CREATE
    public Optional<UtenteResponseDto> insertNewUtente(UtenteRegisterDto dto){
       return Optional.of(utenteRepo.save(UtenteMapper.fromDtoToEntity(dto))).map(UtenteMapper::fromEntityToDto);
    }

    //READ
    public Optional<UtenteResponseDto> findUtenteById(Long id){
        return utenteRepo.findById(id).map(UtenteMapper::fromEntityToDto);
    }

    public List<UtenteResponseDto> findAllUtente(){
        return utenteRepo.findAll().stream().map(UtenteMapper::fromEntityToDto).toList();
    }

}
