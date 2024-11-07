package com.inditex.precios.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.inditex.precios.model.Precios;



public interface PreciosService {
	
	Optional<Precios> obtenerPrecioAplicable(LocalDateTime startDate, Integer productId, Integer brandId);

}
