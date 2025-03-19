package com.sai.service;

import com.sai.model.LibroDiario;
import com.sai.repository.LibroDiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroDiarioService {

    private final LibroDiarioRepository libroDiarioRepository;

    @Autowired
    public LibroDiarioService(LibroDiarioRepository libroDiarioRepository) {
        this.libroDiarioRepository = libroDiarioRepository;
    }

    public List<LibroDiario> getAllEntries() {
        return libroDiarioRepository.findAll();
    }

    public void save(LibroDiario libroDiario) {
        libroDiarioRepository.save(libroDiario);
    }

    public Optional<LibroDiario> getLastInserted() {
        return libroDiarioRepository.findTopByOrderByIdDesc();
    }
}
