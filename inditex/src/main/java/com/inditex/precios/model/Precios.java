package com.inditex.precios.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;

@Entity
public class Precios {

	@Id
	private Integer brandId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Integer priceList;
	private BigInteger price;
	private Integer productId;
	private Integer priority;
	private String currency;

	public Precios(Integer brandId, LocalDateTime startDate, LocalDateTime endDate, Integer priceList, BigInteger price,
			Integer productId, Integer priority, String currency) {
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceList = priceList;
		this.price = price;
		this.productId = productId;
		this.priority = priority;
		this.currency = currency;
	}

	public Precios() {
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Integer getPriceList() {
		return priceList;
	}

	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}

	public BigInteger getPrice() {
		return price;
	}

	public void setPrice(BigInteger price) {
		this.price = price;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
