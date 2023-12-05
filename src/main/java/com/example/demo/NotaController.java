package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;


@Controller
public class NotaController {
    private final NotaRepository notaRepository;

    public NotaController(NotaRepository repo){
        notaRepository = repo;
    }

    @GetMapping("/newnote")
    public String addnoteForm(Model model) {
        model.addAttribute("nota", new Nota());
        return "newnote";
    }

    @GetMapping("/home")
    public String getNotes(Model model) {
        System.out.println("Recupero note dal db!");

        model.addAttribute("note", notaRepository.findAll());
        for(Nota nota : notaRepository.findAll())
            System.out.println(nota);
        return "/home";
    }

    @PostMapping("/notes")
    public String createnote(@ModelAttribute("nota") Nota nota, Model model){
        notaRepository.save(nota);
        model.addAttribute("note", notaRepository.findAll());
        System.out.println("nota aggiunta!");

        return "/home";
    }

}
