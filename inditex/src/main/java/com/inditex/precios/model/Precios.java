package com.inditex.precios.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;

@Entity	
public class Precios {
	
	@Id
	private int brandId;
	private LocalDateTime startDate;
	private LocalDateTime startEnd;
	private int priceList;
	private int productId;
	private int priority;
	private String curr;
	
	

}
