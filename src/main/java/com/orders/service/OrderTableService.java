package com.orders.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

			orderTable.setOrdeDate(LocalDateTime.now());
			orderTable.setModifiedDate(LocalDate.now());
			orderTable.setCreatedDate(LocalDate.now());
			orderTable.setCreatedBy(orderTable.getUserId());
//			orderTable.setStatus();
			orderTableRepository.save(orderTable);
		} catch (DataAccessException e) {
	e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
}
