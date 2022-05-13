package com.orders.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "orders_table")
public class OrderTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int order_id ;
	@Column(name = "user_id")
	public int userId;
	@Column(name = "order_date")
	public LocalDateTime ordeDate;
	@Column(name = "status")
	public String status;
	@Column(name = "modified_date")
	public LocalDate modifiedDate;
	@Column(name = "created_date")
	public LocalDate createdDate;
	@Column(name = "created_by")
	public int createdBy;
	@Column(name = "comments")
	public String comments;

}
