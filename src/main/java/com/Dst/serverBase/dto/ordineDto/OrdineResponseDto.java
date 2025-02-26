package com.Dst.serverBase.dto.ordineDto;

import com.Dst.serverBase.entities.DettaglioOrdine;
import com.Dst.serverBase.entities.Utente;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdineResponseDto {

    private LocalDate data;
    private String stato; // IN_ATTESA, SPEDITO, CONSEGNATO
    private Double totale;
    private Utente utente;
    private List<DettaglioOrdine> dettagli;
}
