package com.Dst.serverBase.repositories;

import com.Dst.serverBase.entities.Ordine;
import com.Dst.serverBase.entities.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdineRepo extends JpaRepository<Ordine, Long> {
}
