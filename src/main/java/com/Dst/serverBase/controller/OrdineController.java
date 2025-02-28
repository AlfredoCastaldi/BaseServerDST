package com.Dst.serverBase.controller;

import com.Dst.serverBase.dto.dettagliDto.DettaglioOrdineRegisterDTO;
import com.Dst.serverBase.dto.ordineDto.CarrelloDTO;
import com.Dst.serverBase.dto.ordineDto.OrdineResponseDTO;
import com.Dst.serverBase.dto.ordineDto.OrdineUpdateDTO;
import com.Dst.serverBase.entities.Ordine;
import com.Dst.serverBase.service.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequestMapping("/api/ordine")
@RestController
public class OrdineController {

    @Autowired
    OrdineService ordineService;
    // CREATE
    @PostMapping
    public ResponseEntity<OrdineResponseDTO> newOrder(@RequestParam Long user_id, @RequestBody List<DettaglioOrdineRegisterDTO> dto){
        return ordineService.insertNewOrder(user_id, dto).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }
    //READ
    @GetMapping("/{ordine_id}")
    public ResponseEntity<OrdineResponseDTO> getOrderById(@PathVariable Long ordine_id){
        return ordineService.getOrderById(ordine_id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<OrdineResponseDTO>> getALlOrders(){
        return ResponseEntity.ok(ordineService.getAllOrders());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<OrdineResponseDTO> updateOrderState(@RequestParam String state, @PathVariable Long id){
        return ordineService.updateOrder(id, state).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrdineResponseDTO> updateOrderById(@PathVariable Long id, @RequestBody OrdineUpdateDTO newOrderDto){
        return ordineService.updateOrderById(id, newOrderDto).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }
    @PutMapping("/details/{id}")
    public ResponseEntity<OrdineResponseDTO> updateOrderById(@PathVariable Long id, @RequestBody List<DettaglioOrdineRegisterDTO> dtos){
        return ordineService.updateOrderDetailsById(id, dtos).map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/totale-speso/{userId}")
    public ResponseEntity<CarrelloDTO> getCarrello(@PathVariable Long user_id){
        return ordineService.getCarrello(user_id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/ordini/intervallo")
    public ResponseEntity<?> getCarrelloByDates(@RequestParam String startDate, @RequestParam String endDate){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        try {
        LocalDate dateOne = formatter.parse(startDate, LocalDate::from);
        LocalDate dateTwo = formatter.parse(endDate, LocalDate::from);
        return ResponseEntity.ok(ordineService.getCarrelloByDate(dateOne, dateTwo));
        } catch(DateTimeException e){
        return new ResponseEntity<>("wrong input dates " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
