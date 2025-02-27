package com.Dst.serverBase;

import com.Dst.serverBase.controller.OrdineController;
import com.Dst.serverBase.dto.dettagliDto.DettaglioOrdineRegisterDTO;
import com.Dst.serverBase.entities.DettaglioOrdine;
import com.Dst.serverBase.service.DettagliOrdineService;
import com.Dst.serverBase.service.OrdineService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@WebMvcTest(OrdineController.class)
class ServerBaseApplicationTests {

    @Autowired
    OrdineService ordineService;

    @Mock
    DettagliOrdineService dettagliOrdineService;

    @Test
    void contextLoads() {

    }

    @Test
    void newOrderWorksProperly() {
        DettaglioOrdineRegisterDTO dto = DettaglioOrdineRegisterDTO.builder()
                .prodotto_id(1L)
                .quantita(5)
                .build();
        when(dettagliOrdineService.insertNewDettagli(dto, 1L)).thenReturn(DettaglioOrdine.builder()
                .prezzoTotale(10.0)
                .build());


    }

}
