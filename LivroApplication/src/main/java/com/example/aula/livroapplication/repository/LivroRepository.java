package com.example.aula.livroapplication.repository;

import com.example.aula.livroapplication.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel, UUID> {
}
