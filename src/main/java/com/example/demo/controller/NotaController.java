package com.example.demo.controller;

import com.example.demo.entity.Nota;
import com.example.demo.service.NotaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class NotaController {
    
    @Autowired
    private NotaService notaService;

    @GetMapping("/newnote")
    public String addnoteForm(Model model) {
        model.addAttribute("nota", new Nota());
        return "newnote";
    }

    @GetMapping("/home")
    public String getNotes(Model model) {
        System.out.println("Recupero note dal db!");
        model.addAttribute("note", notaService.getAllNotes());

        return "home";
    }

    @PostMapping("/notes")
    public View createnote(@ModelAttribute("nota") Nota nota, Model model){
        notaService.saveNote(nota);
        model.addAttribute("note", notaService.getAllNotes());
        System.out.println("nota aggiunta!");

        return new RedirectView("home");
    }

}
