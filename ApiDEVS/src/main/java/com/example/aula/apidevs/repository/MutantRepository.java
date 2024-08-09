package com.example.aula.apidevs.repository;

import com.example.aula.apidevs.model.MutantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MutantRepository extends JpaRepository<MutantModel, UUID> {
    long countByIsInSchool(boolean isInSchool);
    List<MutantModel> findByIsInSchool(boolean isInSchool);
}