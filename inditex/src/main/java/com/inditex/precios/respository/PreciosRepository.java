package com.inditex.precios.respository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.precios.model.Precios;

public interface PreciosRepository extends JpaRepository<Precios, Integer>{
	
	 @Query("SELECT p FROM Precios p WHERE p.productId = :productId AND p.brandId = :brandId " +
	           "AND p.startDate <= :applicationDate AND p.endDate >= :applicationDate ")
	    Optional<Precios> obtenerPrecioAplicable(
	            @Param("productId") Integer productId,
	            @Param("brandId") Integer brandId,
	            @Param("applicationDate") LocalDateTime applicationDate);

}
