package com.Dst.serverBase.controller;

import com.Dst.serverBase.dto.dettagliDto.DettaglioOrdineRegisterDTO;
import com.Dst.serverBase.dto.ordineDto.OrdineResponseDTO;
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
    public ResponseEntity<OrdineResponseDTO> newOrder(@RequestParam Long user_id, @RequestBody List<DettaglioOrdineRegisterDTO> dto){
        return ordineService.insertNewOrder(user_id, dto).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<List<OrdineResponseDTO>> getALlOrders(){
        return ResponseEntity.ok(ordineService.getAllOrders());
    }
}
