package com.example.aula.apidestinoviagem.repository;

import com.example.aula.apidestinoviagem.model.DestinoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DestinoRepository extends JpaRepository<DestinoModel, UUID> {
    List<DestinoModel> findByPais(String pais);
    List<DestinoModel> findByCidade(String cidade);
}
