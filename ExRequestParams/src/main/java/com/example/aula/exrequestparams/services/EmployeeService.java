package com.example.aula.exrequestparams.services;

import com.example.aula.exrequestparams.models.EmployeeModel;
import com.example.aula.exrequestparams.repositories.EmployeeRepository;
import com.example.aula.exrequestparams.specifications.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeModel> filterEmployees(String firstName, String department, BigDecimal minSalary, LocalDate hiredAfter, LocalDate hiredBefore, Boolean active) {
        Specification<EmployeeModel> spec = Specification.where(null);

        if (firstName != null && !firstName.isEmpty()) {
            spec = spec.and(EmployeeSpecification.hasFirstName(firstName));
        }
        if (department != null && !department.isEmpty()) {
            spec = spec.and(EmployeeSpecification.hasDepartment(department));
        }
        if (minSalary != null) {
            spec = spec.and(EmployeeSpecification.hasMinSalary(minSalary));
        }
        if (hiredAfter != null) {
            spec = spec.and(EmployeeSpecification.wasHiredAfter(hiredAfter));
        }
        if (hiredBefore != null) {
            spec = spec.and(EmployeeSpecification.wasHiredBefore(hiredBefore));
        }
        if (active != null) {
            spec = spec.and(EmployeeSpecification.isActive(active));
        }

        return employeeRepository.findAll(spec);
    }
}