package com.example.aula.exrequestparams.repositories;

import com.example.aula.exrequestparams.models.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>, JpaSpecificationExecutor<EmployeeModel> {
}
