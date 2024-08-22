package com.example.aula.exrequestparams.specifications;

import com.example.aula.exrequestparams.models.EmployeeModel;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeSpecification {

    public static Specification<EmployeeModel> hasFirstName(String firstName) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("firstName"), firstName);
    }

    public static Specification<EmployeeModel> hasDepartment(String department) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("department"), department);
    }

    public static Specification<EmployeeModel> hasMinSalary(BigDecimal minSalary) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.greaterThanOrEqualTo(root.get("salary"), minSalary);
    }

    public static Specification<EmployeeModel> wasHiredAfter(LocalDate hiredAfter) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.greaterThanOrEqualTo(root.get("hireDate"), hiredAfter);
    }

    public static Specification<EmployeeModel> wasHiredBefore(LocalDate hiredBefore) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.lessThanOrEqualTo(root.get("hireDate"), hiredBefore);
    }

    public static Specification<EmployeeModel> isActive(Boolean active) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("active"), active);
    }
}