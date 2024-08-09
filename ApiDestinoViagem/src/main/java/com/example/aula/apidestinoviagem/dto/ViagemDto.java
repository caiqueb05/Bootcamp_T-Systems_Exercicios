package com.example.aula.apidestinoviagem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ViagemDto(@NotBlank String nome, @NotNull LocalDate dataInicio, @NotNull LocalDate dataFim, @NotNull String destinoId) {
}
