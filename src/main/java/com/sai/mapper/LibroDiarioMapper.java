package com.sai.mapper;

import com.sai.dto.LibroDiarioRequest;
import com.sai.model.LibroDiario;
import org.springframework.stereotype.Component;

@Component
public class LibroDiarioMapper {

    public LibroDiario toEntity(LibroDiarioRequest libroDiarioRequest) {
       return new LibroDiario(libroDiarioRequest.fecha(),
               libroDiarioRequest.concepto(),
               libroDiarioRequest.ingreso(),
               libroDiarioRequest.egreso(),
               libroDiarioRequest.saldo());
    }
}
