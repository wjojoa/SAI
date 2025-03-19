package com.sai.controller;

import com.sai.model.LibroDiario;
import com.sai.service.LibroDiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String saveEntry(@ModelAttribute LibroDiario libroDiario) {
        // Guarda la entrada usando el servicio
        System.out.println("librodiario" + libroDiario);
        LibroDiario libroDiario1 = libroDiarioService.getLibroDiario(18);
  libroDiario1.setSaldo(libroDiario.getIngreso());
        libroDiario.setIngreso(libroDiario.getIngreso());
        libroDiarioService.saveEntry(libroDiario1);
        return "index";  // Redirige de vuelta al formulario
    }

}

