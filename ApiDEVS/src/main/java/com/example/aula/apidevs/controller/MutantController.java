package com.example.aula.apidevs.controller;

import com.example.aula.apidevs.dto.MutantDto;
import com.example.aula.apidevs.model.MutantModel;
import com.example.aula.apidevs.repository.MutantRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/mutant")
public class MutantController {

    @Autowired
    MutantRepository mutantRepository;

    @GetMapping
    public ResponseEntity<List<MutantModel>> getAllMutants() {
        return ResponseEntity.status(HttpStatus.OK).body(mutantRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getMutantById(@PathVariable(value = "id") UUID id) {
        MutantModel mutant = mutantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mutant not found"));

        int alienDefeats = (int) (mutant.getEnemiesDefeated() * 0.268);
        boolean shouldRecruit = alienDefeats > 20;
        String message = shouldRecruit ? "Eligible for E.S.P.A.D.A. recruitment" : "Not eligible for E.S.P.A.D.A. recruitment";

        return ResponseEntity.status(HttpStatus.OK).body(new Object() {
            public final MutantModel mutantDetails = mutant;
            public final String recruitmentStatus = message;
        });
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerMutant(@Valid @RequestBody MutantDto mutantDTO) {
        if (!"apocalipse".equals(mutantDTO.password())) {
            throw new IllegalArgumentException("Invalid password");
        }
        MutantModel mutant = new MutantModel();
        BeanUtils.copyProperties(mutantDTO, mutant);
        mutant.setInSchool(false);
        MutantModel savedMutant = mutantRepository.save(mutant);

        int alienDefeats = (int) (mutantDTO.enemiesDefeated() * 0.268);
        int demonDefeats = (int) (mutantDTO.enemiesDefeated() * 0.732);
        String message = alienDefeats > 20
                ? "You have been recruited to E.S.P.A.D.A. (Equipe de Supervisão, Pesquisa, Avaliação e Defesa Armada)"
                : "Not eligible for E.S.P.A.D.A. recruitment";

        return ResponseEntity.status(HttpStatus.CREATED).body(new Object() {
            public final MutantModel mutant = savedMutant;
            public final String recruitmentMessage = message;
            public final int alienDefeatsValue = alienDefeats;
            public final int demonDefeatsValue = demonDefeats;
        });
    }

    @PostMapping("/entry/{id}")
    public void logEntry(@PathVariable UUID id) {
        MutantModel mutant = mutantRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
        mutant.setInSchool(true);
        mutantRepository.save(mutant);
    }

    @PostMapping("/exit/{id}")
    public void logExit(@PathVariable UUID id) {
        MutantModel mutant = mutantRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
        mutant.setInSchool(false);
        mutantRepository.save(mutant);
    }

    @GetMapping("/count")
    public long countMutantsInSchool() {
        return mutantRepository.countByIsInSchool(true);
    }

    @GetMapping("/list")
    public List<MutantModel> listMutantsInSchool() {
        return mutantRepository.findByIsInSchool(true);
    }


}
