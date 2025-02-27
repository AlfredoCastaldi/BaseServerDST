package com.Dst.serverBase.service;

import com.Dst.serverBase.dto.prodottoDto.ProdottoMapperDTO;
import com.Dst.serverBase.dto.prodottoDto.ProdottoRegisterDTO;
import com.Dst.serverBase.dto.prodottoDto.ProdottoResponseDTO;
import com.Dst.serverBase.entities.Prodotto;
import com.Dst.serverBase.repositories.ProdottoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdottoService {


    @Autowired
    ProdottoRepo prodottoRepo;

    public Optional<ProdottoResponseDTO> insertNewProdotto(ProdottoRegisterDTO dto){
        return Optional.of(prodottoRepo.save(ProdottoMapperDTO.fromDtoToEntity(dto))).map(ProdottoMapperDTO::fromEntityToDto);
    }

    // READ
    public List<ProdottoResponseDTO> findAllProdotto(){
        return prodottoRepo.findAll().stream().map(ProdottoMapperDTO::fromEntityToDto).toList();
    }

    // UPDATE

    public Optional<ProdottoResponseDTO> updateProduct(Long id_prodotto, ProdottoRegisterDTO dto){
        Prodotto oldProdotto = prodottoRepo.findById(id_prodotto).get();
        if (oldProdotto != null){
            oldProdotto = ProdottoMapperDTO.fromDtoToEntity(dto);
           return Optional.of(prodottoRepo.save(oldProdotto)).map(ProdottoMapperDTO::fromEntityToDto);
        } else {
            return Optional.empty();
        }
    }

    //DELETE
    public boolean deleteProdotto(Long id_prodotto){
        prodottoRepo.deleteById(id_prodotto);
        if (prodottoRepo.findById(id_prodotto).isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
