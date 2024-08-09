package com.example.aula.apidevs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MutantDto(@NotBlank String password, @NotBlank String name, @NotBlank String power, @NotNull int age, @NotNull int enemiesDefeated) {
}
