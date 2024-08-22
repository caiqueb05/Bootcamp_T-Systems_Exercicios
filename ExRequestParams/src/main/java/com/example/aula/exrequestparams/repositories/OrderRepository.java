package com.example.aula.exrequestparams.repositories;

import com.example.aula.exrequestparams.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long>, JpaSpecificationExecutor<OrderModel> {
}
