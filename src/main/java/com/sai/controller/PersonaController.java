package com.sai.controller;

import com.sai.model.Persona;
import com.sai.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    public ResponseEntity<Persona> crearPersona(Persona persona){
        Persona newPersona = (Persona) personaRepository.save(persona);
        return (ResponseEntity<Persona>) ResponseEntity.ok(newPersona);
    }
}
