package com.Dst.serverBase.controller;

import com.Dst.serverBase.dto.utenteDto.UtenteRegisterDTO;
import com.Dst.serverBase.dto.utenteDto.UtenteResponseDTO;
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
    public ResponseEntity<UtenteResponseDTO> inserNewUtente0(UtenteRegisterDTO dto){
        return utenteService.insertNewUtente(dto).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("{id}")
    public ResponseEntity<UtenteResponseDTO> getUtenteById(@PathVariable Long id){
        return utenteService.findUtenteById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UtenteResponseDTO>> getUtenteById(){
        return ResponseEntity.ok(utenteService.findAllUtente());
    }

    // UPDATE

    @PutMapping("{id_utente}")
    public ResponseEntity<UtenteResponseDTO> updateUtenteById(@PathVariable Long id_utente, @RequestBody UtenteRegisterDTO dto){
        return utenteService.updateUtenteById(id_utente, dto).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUtenteById(@RequestParam Long id_utente){
        if (utenteService.deleteUtenteById(id_utente)){
            return ResponseEntity.ok("utente eliminato con successo");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
