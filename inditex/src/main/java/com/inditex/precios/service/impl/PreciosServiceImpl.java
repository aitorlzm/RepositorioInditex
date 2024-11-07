package com.inditex.precios.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.precios.dto.PreciosDTO;
import com.inditex.precios.respository.PreciosRepository;
import com.inditex.precios.service.PreciosService;

@Service
public class PreciosServiceImpl implements PreciosService {
	
	
	private PreciosRepository preciosRepository;

	@Autowired
	public PreciosServiceImpl(PreciosRepository preciosRepository) {
		this.preciosRepository = preciosRepository;
	}

	@Override
	public Optional<PreciosDTO> obtenerPrecioAplicable(LocalDateTime fecha, Integer productId, Integer brandId) {
		return preciosRepository
	            .obtenerFechaAplicacion(productId, brandId, fecha)
	            .map(precio -> new PreciosDTO(precio.getProductId(), precio.getBrandId(), precio.getPriceList(),
	                                          precio.getStartDate(), precio.getEndDate(), precio.getPrice()));
	}

}
