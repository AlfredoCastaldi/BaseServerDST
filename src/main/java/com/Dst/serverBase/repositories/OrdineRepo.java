package com.Dst.serverBase.repositories;

import com.Dst.serverBase.dto.ordineDto.CarrelloDTO;
import com.Dst.serverBase.entities.Ordine;
import com.Dst.serverBase.entities.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdineRepo extends JpaRepository<Ordine, Long> {


}
