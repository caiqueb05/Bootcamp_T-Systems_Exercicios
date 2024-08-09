package com.example.aula.apidevs.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "mutant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MutantModel implements Serializable {
    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Power is required")
    private String power;

    @NotNull(message = "Age is required")
    private int age;

    @NotNull(message = "Enemies defeated is required")
    private int enemiesDefeated;

    private boolean isInSchool;
}
