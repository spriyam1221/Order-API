package com.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orders.model.OrderTable;

@Repository
public interface OrderTableRepository extends JpaRepository<OrderTable, Integer>{

}
