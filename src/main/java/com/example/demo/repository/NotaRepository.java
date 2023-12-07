package com.example.demo.repository;

import com.example.demo.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotaRepository extends JpaRepository<Nota, Long> {

    List<Nota>  findByOrderByIdDesc();

}