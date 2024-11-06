package com.inditex.precios.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.precios.model.Precios;
import com.inditex.precios.service.PreciosService;


@RestController
@RequestMapping("/api/precios")
public class PreciosController {
	
    @Autowired
    private PreciosService preciosService;
    
    @GetMapping ("/ConsultarPrecioAplicable")
	public ResponseEntity<Precios> obtenerPrecioAplicable(
			@RequestParam("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") LocalDateTime fecha,
	        @RequestParam("productoId") Integer productId,
	        @RequestParam("marcaId") Integer brandId){
    	
		return preciosService.obtenerPrecioProducto(fecha, productId, brandId)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
    	
	   	
    }

}
