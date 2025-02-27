package com.Dst.serverBase.service;

import com.Dst.serverBase.dto.utenteDto.UtenteMapperDTO;
import com.Dst.serverBase.dto.utenteDto.UtenteRegisterDTO;
import com.Dst.serverBase.dto.utenteDto.UtenteResponseDTO;
import com.Dst.serverBase.entities.Utente;
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
    public Optional<UtenteResponseDTO> insertNewUtente(UtenteRegisterDTO dto){
       return Optional.of(utenteRepo.save(UtenteMapperDTO.fromDtoToEntity(dto))).map(UtenteMapperDTO::fromEntityToDto);
    }

    //READ
    public Optional<UtenteResponseDTO> findUtenteById(Long id){
        return utenteRepo.findById(id).map(UtenteMapperDTO::fromEntityToDto);
    }

    public List<UtenteResponseDTO> findAllUtente(){
        return UtenteMapperDTO.fromEntitiesListToDTOList(utenteRepo.findAll());
    }

    //UPDATE
    public Optional<UtenteResponseDTO> updateUtenteById(Long utente_id, UtenteRegisterDTO dto){
        Optional<UtenteResponseDTO> oldRecord = findUtenteById(utente_id);
        if (oldRecord.isPresent()){
            Utente utente = UtenteMapperDTO.fromDtoToEntity(dto);
            utente.setId(utente_id);
            return Optional.of(utenteRepo.save(utente)).map(UtenteMapperDTO::fromEntityToDto);
        } else {
            return Optional.empty();
        }
    }

    //DELETE
    public boolean deleteUtenteById(Long utente_id){
        if (findUtenteById(utente_id).isPresent()){
            utenteRepo.deleteById(utente_id);
            return true;
        } else {
            return false;
        }
    }

}
