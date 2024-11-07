package com.inditex.precios.config;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.inditex.precios.model.Precios;
import com.inditex.precios.respository.PreciosRepository;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final PreciosRepository preciosRepository;
	
	@Autowired
	public DataLoader(PreciosRepository preciosRepository) {
		this.preciosRepository = preciosRepository;
	}

	@Override
	public void run(String... args) throws Exception {
	       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

	        preciosRepository.save(new Precios(1, LocalDateTime.parse("2020-06-14-00.00.00", formatter), 
	                LocalDateTime.parse("2020-12-31-23.59.59", formatter), 1, new BigDecimal("35.50"), 
	                35455, 0, "EUR"));

	        preciosRepository.save(new Precios(1, LocalDateTime.parse("2020-06-14-15.00.00", formatter), 
	                LocalDateTime.parse("2020-06-14-18.30.00", formatter), 2, new BigDecimal("25.45"), 
	                35455, 1, "EUR"));

	        preciosRepository.save(new Precios(1, LocalDateTime.parse("2020-06-15-00.00.00", formatter), 
	                LocalDateTime.parse("2020-06-15-11.00.00", formatter), 3, new BigDecimal("30.50"), 
	                35455, 1, "EUR"));

	        preciosRepository.save(new Precios(1, LocalDateTime.parse("2020-06-15-16.00.00", formatter), 
	                LocalDateTime.parse("2020-12-31-23.59.59", formatter), 4, new BigDecimal("38.95"), 
	                35455, 1, "EUR"));
	        
        System.out.println("Datos iniciales cargados en la base de datos.");

	}
}

