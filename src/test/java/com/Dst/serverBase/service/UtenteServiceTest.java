package com.Dst.serverBase.service;

import com.Dst.serverBase.dto.utenteDto.UtenteRegisterDTO;
import com.Dst.serverBase.dto.utenteDto.UtenteResponseDTO;
import com.Dst.serverBase.entities.Utente;
import com.Dst.serverBase.repositories.UtenteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@SpringBootTest
public class UtenteServiceTest {


    @Mock
    UtenteRepo utenteRepo;
    @Autowired
    UtenteService utenteService;

    @Test
    void insertUtenteWorks() {
        Utente mockUtente = Utente.builder()
                .nome("test nome")
                .email("test email")
                .build();
        UtenteRegisterDTO dtoMock = UtenteRegisterDTO.builder()
                .nome("test nome")
                .email("test email")
                .build();
        when(utenteRepo.save(mockUtente)).thenReturn(mockUtente);

        UtenteResponseDTO result = utenteService.insertNewUtente(dtoMock).get();
        Assertions.assertEquals("test nome", result.getNome());
        Assertions.assertEquals("test email", result.getEmail());

    }


}
