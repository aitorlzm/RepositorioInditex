package com.inditex.precios.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.inditex.precios.dto.PreciosDTO;


public interface PreciosService {
	
	Optional<PreciosDTO> obtenerPrecioAplicable(LocalDateTime startDate, Integer productId, Integer brandId);

}
