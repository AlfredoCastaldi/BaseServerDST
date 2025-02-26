package com.Dst.serverBase.dto.ordineDto;

import com.Dst.serverBase.entities.Ordine;
import com.Dst.serverBase.repositories.UtenteRepo;
import com.Dst.serverBase.service.UtenteService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;

public class OrdineDtoMapper {

    @Autowired
    static UtenteRepo utenteRepo;

    public static Ordine fromDtoToEntity(OrdineRegisterDto dto){
        return Ordine.builder()
                .utente(utenteRepo.findById(dto.getUtente_id()).get())
                .build();
    }
}
