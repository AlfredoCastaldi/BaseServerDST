package com.Dst.serverBase.repositories;

import com.Dst.serverBase.entities.DettaglioOrdine;
import com.Dst.serverBase.entities.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DettaglioOrdineRepo extends JpaRepository<DettaglioOrdine, Long> {
}
