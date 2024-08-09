package com.example.aula.apidestinoviagem.controller;

import com.example.aula.apidestinoviagem.dto.DestinoDto;
import com.example.aula.apidestinoviagem.model.DestinoModel;
import com.example.aula.apidestinoviagem.repository.DestinoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/destino")
public class DestinoController {

    @Autowired
    DestinoRepository destinoRepository;

    @GetMapping
    public ResponseEntity<List<DestinoModel>> getAllDestinos() {
        return ResponseEntity.status(HttpStatus.OK).body(destinoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDestinoById(@PathVariable(value = "id") UUID id) {
        DestinoModel destino = destinoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destino nao encontrado"));

        return ResponseEntity.status(HttpStatus.OK).body(destino);

    }

    @GetMapping("/pais/{pais}")
    public ResponseEntity<Object> getDestinoByPais(@PathVariable(value = "pais") String pais) {
        List<DestinoModel> destinos = destinoRepository.findByPais(pais);
        if (destinos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("País não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(destinos);
    }

    @PostMapping
    public ResponseEntity<DestinoModel> addDestino(@RequestBody @Valid DestinoDto destinoDto) {
        DestinoModel destinoModel = new DestinoModel();
        BeanUtils.copyProperties(destinoDto, destinoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(destinoRepository.save(destinoModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDestino(@PathVariable(value = "id") UUID id) {
        Optional<DestinoModel> destinoO = destinoRepository.findById(id);
        if (destinoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino não encontrado");
        } else {
            destinoRepository.delete(destinoO.get());
            return ResponseEntity.status(HttpStatus.OK).body("Destino deletado com sucesso");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDestino(@PathVariable(value = "id") UUID id, @RequestBody @Valid DestinoDto destinoDto) {
        Optional<DestinoModel> destinoO = destinoRepository.findById(id);
        if (destinoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino não encontrado");
        } else {
            DestinoModel destinoModel = destinoO.get();
            BeanUtils.copyProperties(destinoDto, destinoModel);
            return ResponseEntity.status(HttpStatus.OK).body(destinoRepository.save(destinoModel));
        }
    }

    // Endpoint adicional: Retornar todos os destinos que possuem uma determinada cidade
    @GetMapping("/destinos/cidade/{cidade}")
    public ResponseEntity<Object> getDestinosByCidade(@PathVariable(value = "cidade") String cidade) {
        List<DestinoModel> destinos = destinoRepository.findByCidade(cidade);
        if (destinos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum destino encontrado com a cidade especificada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(destinos);
    }

}
