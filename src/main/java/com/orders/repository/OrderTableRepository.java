package com.orders.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orders.model.OrderTable;

@Repository
public interface OrderTableRepository extends JpaRepository<OrderTable, Integer>{
 
	List<OrderTable> findByUserId(Integer userId);
}
