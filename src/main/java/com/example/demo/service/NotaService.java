package com.example.demo.service;

import com.example.demo.entity.Nota;

import java.util.List;

public interface NotaService {
    List<Nota> getAllNotes();
    void saveNote(Nota nota);

}
