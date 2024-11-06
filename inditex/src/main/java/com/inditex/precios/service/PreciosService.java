package com.inditex.precios.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.inditex.precios.model.Precios;



public interface PreciosService {
	
	Optional<Precios> obtenerPrecioProducto(LocalDateTime applicationDate, Integer productId, Integer brandId);

}
