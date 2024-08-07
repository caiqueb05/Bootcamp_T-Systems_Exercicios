package com.example.aula.primeiroprojeto.controller;

import com.example.aula.primeiroprojeto.dto.ProductRecordDto;
import com.example.aula.primeiroprojeto.model.ProductModel;
import com.example.aula.primeiroprojeto.repository.ProductRepository;
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
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable(value="id") UUID id) {
        Optional<ProductModel> product = productRepository.findById(id);
        if(product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product não encontrado");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(product.get());
        }
    }

    @PostMapping
    public ResponseEntity<ProductModel> createProduct(@RequestBody @Valid ProductRecordDto productDto) {
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productDto, productModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") UUID id) {
        Optional<ProductModel> product = productRepository.findById(id);
        if(product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        } else {
            productRepository.delete(product.get());
            return ResponseEntity.status(HttpStatus.OK).body("Produto deletado");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id, @RequestBody @Valid ProductRecordDto productDto) {
        Optional<ProductModel> product = productRepository.findById(id);
        if(product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        } else {
            var productModel = product.get();
            BeanUtils.copyProperties(productDto, productModel);
            return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
        }
    }

}
