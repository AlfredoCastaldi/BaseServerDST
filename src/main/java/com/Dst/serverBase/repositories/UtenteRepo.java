package com.Dst.serverBase.repositories;

import com.Dst.serverBase.entities.Prodotto;
import com.Dst.serverBase.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Long> {
}
