package com.inditex.precios.service;

import java.time.LocalDateTime;
import java.util.List;

import com.inditex.precios.model.Precios;



public interface PreciosServices {
	
	List<Precios> obtenerPrecioProducto(LocalDateTime startDate, LocalDateTime endDate, Long brandId);

}
