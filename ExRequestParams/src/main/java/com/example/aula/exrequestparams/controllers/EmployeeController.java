package com.example.aula.exrequestparams.controllers;

import com.example.aula.exrequestparams.models.EmployeeModel;
import com.example.aula.exrequestparams.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeModel> filterEmployees(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String department,
            @RequestParam(required = false) BigDecimal minSalary,
            @RequestParam(required = false) LocalDate hiredAfter,
            @RequestParam(required = false) LocalDate hiredBefore,
            @RequestParam(required = false) Boolean active) {
        return employeeService.filterEmployees(firstName, department, minSalary, hiredAfter, hiredBefore, active);
    }

}
