package com.Dst.serverBase.service;

import com.Dst.serverBase.dto.dettagliDto.DettagliRegisterDto;
import com.Dst.serverBase.dto.ordineDto.OrdineDtoMapper;
import com.Dst.serverBase.dto.ordineDto.OrdineRegisterDto;
import com.Dst.serverBase.dto.ordineDto.OrdineResponseDto;
import com.Dst.serverBase.entities.DettaglioOrdine;
import com.Dst.serverBase.entities.Ordine;
import com.Dst.serverBase.repositories.OrdineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdineService {

    @Autowired
    OrdineRepo ordineRepo;
    @Autowired
    DettagliOrdineService dettagliOrdineService;


}
