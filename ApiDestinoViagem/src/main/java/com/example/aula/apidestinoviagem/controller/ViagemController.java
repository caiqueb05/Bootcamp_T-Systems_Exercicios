package com.example.aula.apidestinoviagem.controller;

import com.example.aula.apidestinoviagem.dto.ViagemDto;
import com.example.aula.apidestinoviagem.model.ViagemModel;
import com.example.aula.apidestinoviagem.repository.ViagemRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/viagem")
public class ViagemController {

    @Autowired
    ViagemRepository viagemRepository;

    @GetMapping
    public ResponseEntity<List<ViagemModel>> getAllViagens() {
        return ResponseEntity.status(HttpStatus.OK).body(viagemRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getViagemById(@PathVariable(value = "id") UUID id) {
        ViagemModel viagem = viagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viagem não encontrada"));

        return ResponseEntity.status(HttpStatus.OK).body(viagem);

    }

    @GetMapping("/destino/{destinoId}/viagem")
    public ResponseEntity<Object> getViagemByDestino(@PathVariable(value = "destinoId") UUID destinoId) {
        List<ViagemModel> viagens = viagemRepository.findByDestinoId(destinoId);
        if (viagens.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Viagem não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(viagens);
    }

    @PostMapping
    public ResponseEntity<ViagemModel> addViagem(@RequestBody @Valid ViagemDto viagemDto) {
        ViagemModel viagemModel = new ViagemModel();
        BeanUtils.copyProperties(viagemDto, viagemModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(viagemRepository.save(viagemModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteViagem(@PathVariable(value = "id") UUID id) {
        Optional<ViagemModel> viagemO = viagemRepository.findById(id);
        if (viagemO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Viagem não encontrada");
        } else {
            viagemRepository.delete(viagemO.get());
            return ResponseEntity.status(HttpStatus.OK).body("Viagem deletada com sucesso");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateViagem(@PathVariable(value = "id") UUID id, @RequestBody @Valid ViagemDto viagemDto) {
        Optional<ViagemModel> viagemO = viagemRepository.findById(id);
        if (viagemO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Viagem não encontrada");
        }
        ViagemModel viagemModel = viagemO.get();
        BeanUtils.copyProperties(viagemDto, viagemModel);
        return ResponseEntity.status(HttpStatus.OK).body(viagemRepository.save(viagemModel));
    }

    // Endpoint adicional: Retornar todas as viagens que terminam em uma determinada data
    @GetMapping("/viagens/dataFim/{dataFim}")
    public ResponseEntity<Object> getViagensByDataFim(@PathVariable(value = "dataFim") LocalDate dataFim) {
        List<ViagemModel> viagens = viagemRepository.findByDataFim(dataFim);
        if (viagens.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma viagem encontrada com a data de término especificada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(viagens);
    }

}
