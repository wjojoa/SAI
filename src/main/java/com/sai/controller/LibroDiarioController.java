package com.sai.controller;

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

    @Autowired
    public LibroDiarioController(LibroDiarioService libroDiarioService) {
        this.libroDiarioService = libroDiarioService;
    }

    @GetMapping("/")
    public String showForm(Model model) {
        // Corregido el método addAttribute
        model.addAttribute("libroDiario", new LibroDiario());
        return "index";  // Devuelve el nombre de la vista (index.html)
    }

    @PostMapping("/save")
    public String saveEntry(@ModelAttribute LibroDiario libroDiarioRequest) {
        // Guarda la entrada usando el servicio
        System.out.print("Log Libro diario obj Request" + libroDiarioRequest);
        Optional<LibroDiario> diarioLastInserted = libroDiarioService.getLastInserted();

        if(diarioLastInserted.isPresent()) {
            //Lo comente como codigo guia para futuros desarrollos
            /*double saldo =  diarioLastInserted.get().getSaldo();
            libroDiarioRequest.setSaldo(libroDiarioRequest.getIngreso() != null ? saldo + libroDiarioRequest.getIngreso() : saldo - libroDiarioRequest.getEgreso());*/

            libroDiarioRequest.actualizarSaldo(diarioLastInserted.get().getSaldo(), libroDiarioRequest);
        } else {
            libroDiarioRequest.setSaldo(libroDiarioRequest.getIngreso()); //2000
        }

        //Lo comente como codigo guia para futuros desarrollos
        //diarioLastInserted.ifPresent(libroDiario -> libroDiarioRequest.actualizarSaldo(libroDiario.getSaldo(), libroDiarioRequest));

        libroDiarioService.save(libroDiarioRequest);
        return "index";  // Redirige de vuelta al formulario
    }

}

