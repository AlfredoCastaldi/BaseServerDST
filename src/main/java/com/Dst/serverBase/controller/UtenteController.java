package com.Dst.serverBase.controller;

import com.Dst.serverBase.dto.utenteDto.UtenteRegisterDto;
import com.Dst.serverBase.dto.utenteDto.UtenteResponseDto;
import com.Dst.serverBase.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("utente")
@RestController
public class UtenteController {

    @Autowired
    UtenteService utenteService;

    @PostMapping
    public ResponseEntity<UtenteResponseDto> inserNewUtente0(UtenteRegisterDto dto){
        return utenteService.insertNewUtente(dto).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("{id}")
    public ResponseEntity<UtenteResponseDto> getUtenteById(@PathVariable Long id){
        return utenteService.findUtenteById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UtenteResponseDto>> getUtenteById(){
        return ResponseEntity.ok(utenteService.findAllUtente());
    }

}
