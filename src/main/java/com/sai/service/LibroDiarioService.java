package com.sai.service;

import com.sai.model.LibroDiario;
import com.sai.repository.LibroDiarioCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroDiarioService {

    private final LibroDiarioCrudRepository libroDiarioCrudRepository;

    @Autowired
    public LibroDiarioService(LibroDiarioCrudRepository libroDiarioCrudRepository) {
        this.libroDiarioCrudRepository = libroDiarioCrudRepository;
    }
    public List<LibroDiario> getAllEntries(){
        return (List<LibroDiario>) (List<LibroDiario>) libroDiarioCrudRepository.findAll();
    }
    public void saveEntry(LibroDiario libroDiario){
        libroDiarioCrudRepository.save(libroDiario);
    }
}
