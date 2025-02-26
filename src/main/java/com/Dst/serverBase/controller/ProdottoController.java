package com.Dst.serverBase.controller;


import com.Dst.serverBase.dto.prodottoDto.ProdottoRegisterDto;
import com.Dst.serverBase.dto.prodottoDto.ProdottoResponseDto;
import com.Dst.serverBase.entities.Prodotto;
import com.Dst.serverBase.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prodotto")
public class ProdottoController {

    @Autowired
    ProdottoService prodottoService;

    @PostMapping
    public ResponseEntity<ProdottoResponseDto> newProduct(@RequestBody ProdottoRegisterDto dto){
       return prodottoService.insertNewProdotto(dto).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping ResponseEntity<List<ProdottoResponseDto>> getAllProdotto(){
        return ResponseEntity.ok(prodottoService.findAllProdotto());
    }
}
