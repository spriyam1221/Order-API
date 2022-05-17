package com.orders.model;




import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	public int orderId ;
	
	@Column(name = "user_id")
	public int userId;
	@Column(name="total_price")
	public int totalPrice;
	@Column(name = "order_date")
	 @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public LocalDateTime orderDate;
	@Column(name = "status")
	public String status;
	@Column(name = "modified_date")
	 @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public LocalDateTime modifiedDate;
	@Column(name = "created_date")
	 @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public LocalDateTime createdDate;
	@Column(name = "created_by")
	public int createdBy;
	@Column(name = "comments")
	public String comments;
	
	
	public String description;

}
