package com.sai.repository;

import com.sai.model.LibroDiario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*LibroDiario es la clase y Integer tipo de dato PK*/
@Repository
public interface LibroDiarioCrudRepository extends CrudRepository<LibroDiario, Integer> {
    LibroDiario findById(int id);
}

