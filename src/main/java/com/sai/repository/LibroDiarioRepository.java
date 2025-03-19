package com.sai.repository;

import com.sai.model.LibroDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*LibroDiario es la clase y Integer tipo de dato PK*/
@Repository
public interface LibroDiarioRepository extends JpaRepository<LibroDiario, Integer> {
    Optional<LibroDiario> findTopByOrderByIdDesc();
}

