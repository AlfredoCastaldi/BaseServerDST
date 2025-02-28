package com.Dst.serverBase.controller;


import com.Dst.serverBase.dto.prodottoDto.ProdottoRegisterDTO;
import com.Dst.serverBase.dto.prodottoDto.ProdottoResponseDTO;
import com.Dst.serverBase.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prodotto")
public class ProdottoController {

    @Autowired
    ProdottoService prodottoService;

    @PostMapping
    public ResponseEntity<ProdottoResponseDTO> newProduct(@RequestBody ProdottoRegisterDTO dto){
       return prodottoService.insertNewProdotto(dto).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping ResponseEntity<List<ProdottoResponseDTO>> getAllProdotto(){
        return ResponseEntity.ok(prodottoService.findAllProdotto());
    }

    @PutMapping("/{id}")
    ResponseEntity<ProdottoResponseDTO> updateProdotto(@RequestBody ProdottoRegisterDTO dto, @PathVariable Long id){
        return prodottoService.updateProduct(id, dto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping
    ResponseEntity<String> deleteProdotto(@RequestParam Long id_prodotto){
       if (prodottoService.deleteProdotto(id_prodotto)){
           return ResponseEntity.ok("prodotto eliminato con successo");
       } else {
           return ResponseEntity.notFound().build();
       }
    }
}
