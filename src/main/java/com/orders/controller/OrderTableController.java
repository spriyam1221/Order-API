package com.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orders.exception.ServiceException;
import com.orders.exception.ValidationException;
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
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (ServiceException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
}
