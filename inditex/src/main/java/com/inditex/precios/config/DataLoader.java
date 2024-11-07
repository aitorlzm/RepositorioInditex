package com.inditex.precios.config;

import java.math.BigInteger;
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
		preciosRepository.save(new Precios(1, LocalDateTime.of(2023, 5, 1, 0, 0), LocalDateTime.of(2023, 5, 31, 23, 59), 1, new BigInteger("5000"), 35455, 1, "EUR"));
        preciosRepository.save(new Precios(1, LocalDateTime.of(2023, 6, 1, 0, 0), LocalDateTime.of(2023, 6, 30, 23, 59), 2, new BigInteger("6000"), 35455, 1, "EUR"));
        preciosRepository.save(new Precios(2, LocalDateTime.of(2023, 5, 1, 0, 0), LocalDateTime.of(2023, 5, 31, 23, 59), 1, new BigInteger("7000"), 10000, 2, "USD"));
        preciosRepository.save(new Precios(2, LocalDateTime.of(2023, 6, 1, 0, 0), LocalDateTime.of(2023, 6, 30, 23, 59), 2, new BigInteger("8000"), 10000, 2, "USD"));
        preciosRepository.save(new Precios(3, LocalDateTime.of(2023, 7, 1, 0, 0), LocalDateTime.of(2023, 7, 31, 23, 59), 3, new BigInteger("4500"), 20000, 1, "EUR"));
        preciosRepository.save(new Precios(3, LocalDateTime.of(2023, 8, 1, 0, 0), LocalDateTime.of(2023, 8, 31, 23, 59), 4, new BigInteger("5500"), 20000, 1, "EUR"));
        preciosRepository.save(new Precios(1, LocalDateTime.of(2023, 9, 1, 0, 0), LocalDateTime.of(2023, 9, 30, 23, 59), 1, new BigInteger("9000"), 35455, 3, "USD"));
        preciosRepository.save(new Precios(1, LocalDateTime.of(2023, 10, 1, 0, 0), LocalDateTime.of(2023, 10, 31, 23, 59), 2, new BigInteger("10000"), 35455, 3, "USD"));
        preciosRepository.save(new Precios(2, LocalDateTime.of(2023, 11, 1, 0, 0), LocalDateTime.of(2023, 11, 30, 23, 59), 3, new BigInteger("11000"), 10000, 2, "EUR"));
        preciosRepository.save(new Precios(2, LocalDateTime.of(2023, 12, 1, 0, 0), LocalDateTime.of(2023, 12, 31, 23, 59), 4, new BigInteger("12000"), 10000, 2, "EUR"));
        preciosRepository.save(new Precios(1, LocalDateTime.of(2024, 1, 1, 0, 0), LocalDateTime.of(2024, 1, 31, 23, 59), 5, new BigInteger("15000"), 35455, 4, "GBP"));
        preciosRepository.save(new Precios(3, LocalDateTime.of(2024, 2, 1, 0, 0), LocalDateTime.of(2024, 2, 29, 23, 59), 1, new BigInteger("3000"), 20000, 1, "GBP"));
        preciosRepository.save(new Precios(2, LocalDateTime.of(2024, 3, 1, 0, 0), LocalDateTime.of(2024, 3, 31, 23, 59), 3, new BigInteger("17000"), 10000, 4, "USD"));
        preciosRepository.save(new Precios(1, LocalDateTime.of(2024, 4, 1, 0, 0), LocalDateTime.of(2024, 4, 30, 23, 59), 2, new BigInteger("16000"), 35455, 2, "USD"));
        preciosRepository.save(new Precios(3, LocalDateTime.of(2024, 5, 1, 0, 0), LocalDateTime.of(2024, 5, 31, 23, 59), 4, new BigInteger("14000"), 20000, 3, "EUR"));
		
        System.out.println("Datos iniciales cargados en la base de datos.");

	}
}

