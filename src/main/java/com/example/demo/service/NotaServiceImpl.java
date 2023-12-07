package com.example.demo.service;

import com.example.demo.entity.Nota;
import com.example.demo.repository.NotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaServiceImpl implements NotaService {

    private final NotaRepository notaRepository;
    NotaServiceImpl(NotaRepository notaRepository){
        this.notaRepository = notaRepository;
    }

    @Override
    public List<Nota> getAllNotes() {
        return notaRepository.findByOrderByIdDesc();
    }

    public void saveNote(Nota nota){
        notaRepository.save(nota);
    }
}
