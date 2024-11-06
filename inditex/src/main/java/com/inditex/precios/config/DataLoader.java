package com.inditex.precios.loader;

import com.inditex.precios.model.Precios;
import com.inditex.precios.repository.PreciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final PreciosRepository preciosRepository;

    @Autowired
    public DataLoader(PreciosRepository preciosRepository) {
        this.preciosRepository = preciosRepository;
    }

    @Override
    public void run(String... args) {
        // Ejemplo de datos iniciales
        Precios precio1 = new Precios(1, LocalDateTime.of(2023, 5, 1, 0, 0), 
                LocalDateTime.of(2023, 5, 31, 23, 59), 1, new BigInteger("5000"), 35455, 1, "EUR");
        
        Precios precio2 = new Precios(1, LocalDateTime.of(2023, 6, 1, 0, 0), 
                LocalDateTime.of(2023, 6, 30, 23, 59), 2, new BigInteger("6000"), 35455, 1, "EUR");
        
        // Guardar en la base de datos
        preciosRepository.save(precio1);
        preciosRepository.save(precio2);
        
        System.out.println("Datos iniciales cargados en la base de datos.");
    }
}
