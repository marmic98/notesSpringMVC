package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;


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

        model.addAttribute("note", notaRepository.findByOrderByIdDesc());
        for(Nota nota : notaRepository.findByOrderByIdDesc())
            System.out.println(nota);
        return "home";
    }

    @PostMapping("/notes")
    public View createnote(@ModelAttribute("nota") Nota nota, Model model){
        notaRepository.save(nota);
        model.addAttribute("note", notaRepository.findAll());
        System.out.println("nota aggiunta!");

        return new RedirectView("home");
    }

}
