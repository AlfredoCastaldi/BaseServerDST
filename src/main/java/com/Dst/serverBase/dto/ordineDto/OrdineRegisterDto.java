package com.Dst.serverBase.dto.ordineDto;

import com.Dst.serverBase.entities.DettaglioOrdine;
import com.Dst.serverBase.entities.Utente;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdineRegisterDto {

    private Long utente_id;

}
