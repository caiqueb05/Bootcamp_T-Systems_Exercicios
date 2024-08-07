package com.example.aula.livroapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LivroModel implements Serializable {
    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String titulo;
    private String autor;
    private String editora;
    private int anoPublicacao;
    private int numeroPaginas;
    private String genero;
    private String idioma;
    private String isbn;
    private String resumo;

}
