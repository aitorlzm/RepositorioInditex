package com.inditex.precios.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Precios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Genera el ID automáticamente
	private Long id;

	private Integer brandId;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Integer priceList;
	private BigDecimal price;
	private Integer productId;
	private Integer priority;
	private String currency;

}
