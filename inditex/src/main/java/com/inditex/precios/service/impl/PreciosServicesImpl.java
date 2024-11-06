package com.inditex.precios.service.impl;

import java.time.LocalDateTime;
import java.util.List;

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
	public List<Precios> obtenerPrecioProducto(LocalDateTime startDate, LocalDateTime endDate, Long brandId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
