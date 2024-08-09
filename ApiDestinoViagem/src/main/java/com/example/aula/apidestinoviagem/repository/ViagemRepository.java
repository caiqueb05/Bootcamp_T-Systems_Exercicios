package com.example.aula.apidestinoviagem.repository;

import com.example.aula.apidestinoviagem.model.ViagemModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ViagemRepository extends JpaRepository<ViagemModel, UUID> {
    List<ViagemModel> findByDataInicio(LocalDate dataInicio);
    List<ViagemModel> findByDestinoId(UUID destinoId);
    List<ViagemModel> findByDataFim(LocalDate dataFim);
}
