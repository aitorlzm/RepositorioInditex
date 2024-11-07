package com.inditex.precios.respository;

import com.inditex.precios.model.Precios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PreciosRepository extends JpaRepository<Precios, Long> {

    @Query(value = "SELECT * FROM precios p WHERE p.product_id = :productId AND p.brand_id = :brandId " +
           "AND :fecha BETWEEN p.start_date AND p.end_date " +
           "ORDER BY p.priority DESC LIMIT 1", nativeQuery = true)
    Optional<Precios> obtenerFechaAplicacion(
            @Param("productId") Integer productId,
            @Param("brandId") Integer brandId,
            @Param("fecha") LocalDateTime fecha);
}
