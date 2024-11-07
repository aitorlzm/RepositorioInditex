package com.inditex.precios.config;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
		preciosRepository.save(new Precios(1, LocalDateTime.of(2023, 5, 1, 0, 0), LocalDateTime.of(2023, 5, 31, 23, 59), 1, new BigDecimal("34.99"), 35455, 1, "EUR"));
        preciosRepository.save(new Precios(1, LocalDateTime.of(2023, 6, 1, 0, 0), LocalDateTime.of(2023, 6, 30, 23, 59), 2, new BigDecimal("35.90"), 35455, 1, "EUR"));
        preciosRepository.save(new Precios(1, LocalDateTime.of(2023, 6, 2, 0, 0), LocalDateTime.of(2023, 6, 30, 23, 59), 2, new BigDecimal("40.99"), 35455, 2, "EUR"));

        System.out.println("Datos iniciales cargados en la base de datos.");

	}
}

