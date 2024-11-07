package com.inditex.precios.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.precios.model.Precios;
import com.inditex.precios.respository.PreciosRepository;
import com.inditex.precios.service.PreciosService;
import com.inditex.precios.specifications.PreciosSpecifications;

@Service
public class PreciosServiceImpl implements PreciosService {
	
	
	private PreciosRepository preciosRepository;

	@Autowired
	public PreciosServiceImpl(PreciosRepository preciosRepository) {
		this.preciosRepository = preciosRepository;
	}
	
	@Override
	public Optional<Precios> obtenerPrecioAplicable(LocalDateTime startDate, Integer productId, Integer brandId) {
        return preciosRepository.findAll(PreciosSpecifications.obtenerPreciosPorMarcaYRango(productId, brandId, startDate))
        		.stream()
        		.findFirst();

	}






	

}
