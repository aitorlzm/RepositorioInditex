package com.inditex.precios.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.precios.dto.PreciosDTO;
import com.inditex.precios.service.PreciosService;


@RestController
@RequestMapping("/api/precios")
public class PreciosController {
	
	private PreciosService preciosService;
    
    @Autowired
    public PreciosController(PreciosService preciosService) {
        this.preciosService = preciosService;
    }
    
    @GetMapping ("/consultar")
	public ResponseEntity<PreciosDTO> obtenerPrecioAplicable(
			@RequestParam("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss") LocalDateTime fecha,
	        @RequestParam("productoId") Integer productId,
	        @RequestParam("marcaId") Integer brandId){
    	
        // Llamamos al servicio para obtener el precio aplicable
        Optional<PreciosDTO> precioAplicable = preciosService.obtenerTarifaAplicable(fecha, productId, brandId);
        
        return precioAplicable.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
	
    }

}
