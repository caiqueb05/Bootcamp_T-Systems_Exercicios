package com.example.aula.apidestinoviagem.dto;

import jakarta.validation.constraints.NotBlank;

public record DestinoDto(@NotBlank String nome, String cidade, @NotBlank String estado, @NotBlank String pais, String descricao, String urlImagem) {
}
