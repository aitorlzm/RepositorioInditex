package com.inditex.precios.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.precios.model.Precios;
import com.inditex.precios.respository.PreciosRepository;
import com.inditex.precios.service.PreciosServices;

@Service
public class PreciosServicesImpl implements PreciosServices {
	
	@Autowired
	private PreciosRepository preciosRepository;

	@Override
	public Optional<Precios> obtenerPrecioProducto(LocalDateTime applicationDate, Integer productId, Integer brandId) {
		return preciosRepository.obtenerPrecioAplicable(productId, brandId, applicationDate);
	}




	

}
