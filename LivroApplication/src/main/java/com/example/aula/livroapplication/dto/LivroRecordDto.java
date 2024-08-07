package com.example.aula.livroapplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroRecordDto(@NotBlank String titulo, @NotBlank String autor, @NotBlank String editora, @NotNull Integer quantidade, @NotNull Integer anoPublicacao, @NotNull Integer numeroPaginas, @NotBlank String genero, @NotBlank String idioma, @NotBlank String isbn, @NotBlank String resumo) {
}
