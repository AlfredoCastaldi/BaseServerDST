package com.Dst.serverBase.controller;

import com.Dst.serverBase.dto.dettagliDto.DettagliRegisterDto;
import com.Dst.serverBase.entities.Ordine;
import com.Dst.serverBase.service.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ordine")
@RestController
public class OrdineController {

    @Autowired
    OrdineService ordineService;

    @PostMapping
    public ResponseEntity<Ordine> newOrder(@RequestParam Long user_id, @RequestBody List<DettagliRegisterDto> dto){
        return ResponseEntity.ok(ordineService.insertNewOrder(user_id, dto));
    }
}
