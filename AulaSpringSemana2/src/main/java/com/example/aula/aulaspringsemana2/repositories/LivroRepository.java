package com.example.aula.aulaspringsemana2.repositories;

import com.example.aula.aulaspringsemana2.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
