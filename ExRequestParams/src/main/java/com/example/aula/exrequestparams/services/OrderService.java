package com.example.aula.exrequestparams.services;

import com.example.aula.exrequestparams.models.OrderModel;
import com.example.aula.exrequestparams.repositories.OrderRepository;
import com.example.aula.exrequestparams.specifications.OrderSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderModel> filterOrders(String orderNumber, String customerName, String status, BigDecimal minAmount, BigDecimal maxAmount, LocalDate startDate, LocalDate endDate) {
        Specification<OrderModel> spec = Specification.where(null);

        if (orderNumber != null && !orderNumber.isEmpty()) {
            spec = spec.and(OrderSpecification.hasOrderNumber(orderNumber));
        }
        if (customerName != null && !customerName.isEmpty()) {
            spec = spec.and(OrderSpecification.hasCustomerName(customerName));
        }
        if (status != null && !status.isEmpty()) {
            spec = spec.and(OrderSpecification.hasStatus(status));
        }
        if (minAmount != null) {
            spec = spec.and(OrderSpecification.hasMinAmount(minAmount));
        }
        if (maxAmount != null) {
            spec = spec.and(OrderSpecification.hasMaxAmount(maxAmount));
        }
        if (startDate != null) {
            spec = spec.and(OrderSpecification.hasStartDate(startDate));
        }
        if (endDate != null) {
            spec = spec.and(OrderSpecification.hasEndDate(endDate));
        }

        return orderRepository.findAll(spec);
    }
}