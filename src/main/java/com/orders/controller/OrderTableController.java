package com.orders.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orders.dto.MessageDTO;
import com.orders.model.OrderTable;
import com.orders.repository.OrderTableRepository;
import com.orders.service.OrderTableService;






@RestController
public class OrderTableController {

	@Autowired
	OrderTableRepository  orderTableRepository;
	
	@Autowired
	OrderTableService orderTableService;
	
	@PostMapping("ordersTable/save")
	public ResponseEntity<?> save(@RequestBody OrderTable orderTable)  {
		try {
			orderTableService.save(orderTable);
			MessageDTO message = new MessageDTO("Success");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("ordersTable/list")
	
		public List<OrderTable> findAll()
		{
			List<OrderTable> orderTable =orderTableRepository.findAll();
		    return  orderTable ;
		}
	@GetMapping("ordersTable/search")
	public List<OrderTable> findById(@RequestParam("userId") Integer userId) {
		List<OrderTable> orderList = orderTableRepository.findByUserId(userId);
		return orderList;
		}
	}





