package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
public class Nota {

    @Id
    @GeneratedValue
    private Long id;
    private String titolo;
    private String contenuto;

    public Nota(){}

    public Nota (String titolo, String contenuto){
        this.titolo = titolo;
        this.contenuto = contenuto;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "titolo='" + titolo + '\'' +
                ", contenuto='" + contenuto + '\'' +
                '}';
    }
}