package com.Dst.serverBase.dto.dettagliDto;


import com.Dst.serverBase.entities.Ordine;
import com.Dst.serverBase.entities.Prodotto;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DettagliRegisterDto {

    private Integer quantita;

    private Long prodotto_id;
}
