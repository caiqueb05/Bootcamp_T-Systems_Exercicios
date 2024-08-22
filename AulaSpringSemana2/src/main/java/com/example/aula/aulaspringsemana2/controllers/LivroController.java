package com.example.aula.aulaspringsemana2.controllers;

import com.example.aula.aulaspringsemana2.models.Livro;
import com.example.aula.aulaspringsemana2.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> buscarLivro(
            @RequestParam(value = "titulo", required = false) String titulo,
            @RequestParam(value = "autor", required = false) String autor,
            @RequestParam(value = "categoria", required = false) String categoria,
            @RequestParam(value =  "price_gt", required = false) Double preco_gt
            ) {
        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setCategoria(categoria);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);



        Example<Livro> example = Example.of(livro, matcher);

        List<Livro> livros = livroService.buscarLivros(example);

        return ResponseEntity.ok(livros);
    }
}
