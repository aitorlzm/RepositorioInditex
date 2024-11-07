package com.inditex.precios.respository;



import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.precios.dto.PreciosDTO;
import com.inditex.precios.model.Precios;

public interface PreciosRepository extends JpaRepository<Precios, Long>{
	
    @Query("SELECT new com.inditex.precios.dto.PreciosDTO(p.productId, p.brandId, p.priceList, " +
            "p.startDate, p.endDate, p.price) " +
            "FROM Precios p WHERE p.productId = :productId AND p.brandId = :brandId " +
            "AND :fecha BETWEEN p.startDate AND p.endDate " +
            "ORDER BY p.priority DESC")
     Optional<PreciosDTO> obtenerFechaAplicacion(@Param("productId") Integer productId,
                                              @Param("brandId") Integer brandId,
                                              @Param("fecha") LocalDateTime fecha);
}
