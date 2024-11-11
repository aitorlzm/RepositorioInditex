package com.inditex.precios.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inditex.precios.dto.PreciosDTO;
import com.inditex.precios.respository.PreciosRepository;
import com.inditex.precios.service.PreciosService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PreciosServiceImpl implements PreciosService {
	
	
	private final PreciosRepository preciosRepository;

	@Override
	public Optional<PreciosDTO> obtenerTarifaAplicable(LocalDateTime fecha, Integer productId, Integer brandId) {
		return preciosRepository
	            .obtenerFechaAplicacion(productId, brandId, fecha)
	            .map(precio -> new PreciosDTO(precio.getProductId(), precio.getBrandId(), precio.getPriceList(),
	                                          precio.getStartDate(), precio.getEndDate(), precio.getPrice()));
	}

}
