package com.example.aula.exrequestparams.specifications;

import com.example.aula.exrequestparams.models.OrderModel;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderSpecification {

    public static Specification<OrderModel> hasOrderNumber(String orderNumber) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("orderNumber"), orderNumber);
    }

    public static Specification<OrderModel> hasCustomerName(String customerName) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("customerName"), customerName);
    }

    public static Specification<OrderModel> hasStatus(String status) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("status"), status);
    }

    public static Specification<OrderModel> hasMinAmount(BigDecimal minAmount) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.greaterThanOrEqualTo(root.get("totalAmount"), minAmount);
    }

    public static Specification<OrderModel> hasMaxAmount(BigDecimal maxAmount) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.lessThanOrEqualTo(root.get("totalAmount"), maxAmount);
    }

    public static Specification<OrderModel> hasStartDate(LocalDate startDate) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.greaterThanOrEqualTo(root.get("orderDate"), startDate);
    }

    public static Specification<OrderModel> hasEndDate(LocalDate endDate) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.lessThanOrEqualTo(root.get("orderDate"), endDate);
    }
}