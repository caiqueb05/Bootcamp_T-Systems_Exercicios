package com.example.aula.primeiroprojeto.repository;


import com.example.aula.primeiroprojeto.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {

}
