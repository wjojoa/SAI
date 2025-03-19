package com.sai.controller;

import com.sai.dto.LibroDiarioRequest;
import com.sai.mapper.LibroDiarioMapper;
import com.sai.model.LibroDiario;
import com.sai.service.LibroDiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class LibroDiarioController {

    private final LibroDiarioService libroDiarioService;
    private final LibroDiarioMapper libroDiarioMapper;

    @Autowired
    public LibroDiarioController(LibroDiarioService libroDiarioService, LibroDiarioMapper libroDiarioMapper) {
        this.libroDiarioService = libroDiarioService;
        this.libroDiarioMapper = libroDiarioMapper;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        // Corregido el método addAttribute
        model.addAttribute("libroDiario", new LibroDiario());
        return "librodiario";  // Devuelve el nombre de la vista (librodiario.html)
    }

    @PostMapping("/save")
    public String saveEntry(@ModelAttribute LibroDiarioRequest libroDiarioRequest) {
        // Guarda la entrada usando el servicio

        /*
         We map the LibriDiarioRequest to entity to avoid play directly wit the Entity - We only should use it to persist in database
         */
        LibroDiario libroDiario = libroDiarioMapper.toEntity(libroDiarioRequest);
        System.out.print("Log Libro diario obj Request" + libroDiarioRequest);
        Optional<LibroDiario> diarioLastInserted = libroDiarioService.getLastInserted();

        if (diarioLastInserted.isPresent()) {
            //Lo comente como codigo guia para futuros desarrollos
            /*double saldo =  diarioLastInserted.get().getSaldo();
            libroDiarioRequest.setSaldo(libroDiarioRequest.getIngreso() != null ? saldo + libroDiarioRequest.getIngreso() : saldo - libroDiarioRequest.getEgreso());*/

            libroDiario.actualizarSaldo(diarioLastInserted.get().getSaldo(), libroDiario);
        } else {
            libroDiario.setSaldo(libroDiarioRequest.ingreso()); //2000
        }

        //Lo comente como codigo guia para futuros desarrollos
        //diarioLastInserted.ifPresent(libroDiario -> libroDiarioRequest.actualizarSaldo(libroDiario.getSaldo(), libroDiarioRequest));

        libroDiarioService.save(libroDiario);
        return "librodiario";  // Redirige de vuelta al formulario
    }

}

