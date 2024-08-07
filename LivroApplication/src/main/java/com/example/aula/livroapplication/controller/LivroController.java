package com.example.aula.livroapplication.controller;

import com.example.aula.livroapplication.dto.LivroRecordDto;
import com.example.aula.livroapplication.model.LivroModel;
import com.example.aula.livroapplication.repository.LivroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @GetMapping
    public ResponseEntity<List<LivroModel>> getAllLivros() {
        return ResponseEntity.status(HttpStatus.OK).body(livroRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getLivroById(@PathVariable(value="id") UUID id) {
        Optional<LivroModel> livro = livroRepository.findById(id);
        if(livro.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(livro.get());
        }
    }

    @PostMapping
    public ResponseEntity<LivroModel> createLivro(@RequestBody LivroRecordDto livroDto) {
        LivroModel livroModel = new LivroModel();
        BeanUtils.copyProperties(livroDto, livroModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroRepository.save(livroModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteLivro(@PathVariable(value="id") UUID id) {
        Optional<LivroModel> livro = livroRepository.findById(id);
        if(livro.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado");
        } else {
            livroRepository.delete(livro.get());
            return ResponseEntity.status(HttpStatus.OK).body("Livro deletado");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLivro(@PathVariable(value="id") UUID id, @RequestBody LivroRecordDto livroDto) {
        Optional<LivroModel> livro = livroRepository.findById(id);
        if(livro.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado");
        } else {
            LivroModel livroModel = livro.get();
            BeanUtils.copyProperties(livroDto, livroModel);
            return ResponseEntity.status(HttpStatus.OK).body(livroRepository.save(livroModel));
        }
    }

}
