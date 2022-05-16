package com.orders.service;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.orders.exception.ServiceException;
import com.orders.exception.ValidationException;
import com.orders.model.OrderTable;
import com.orders.repository.OrderTableRepository;

@Service
public class OrderTableService {

	@Autowired
	OrderTableRepository orderTableRepository;
	
	public void save (OrderTable orderTable)throws ValidationException, ServiceException {
		try {

			orderTable.setOrderDate(LocalDateTime.now());
			orderTable.setModifiedDate(LocalDateTime.now());
			orderTable.setCreatedDate(LocalDateTime.now());
			orderTable.setCreatedBy(orderTable.getUserId());
//			orderTable.setStatus();
			orderTableRepository.save(orderTable);
		} catch (DataAccessException e) {
	e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
	public List<OrderTable> findAll() throws ValidationException, ServiceException{
		List<OrderTable> listorder =null;
		try {
			listorder =orderTableRepository.findAll();
		}
		catch(DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
		return listorder;
		
	}
	public OrderTable findById(Integer userId) {

		Optional<OrderTable> order = orderTableRepository.findById(userId);
		if (order.isPresent()) {
			OrderTable orderObj = order.get();
			return orderObj;
		} else {
			return null;
		}
	}
}
