package com.inditex.precios.respository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.inditex.precios.model.Precios;

public interface PreciosRepository extends JpaRepository<Precios, Long>, JpaSpecificationExecutor<Precios>{
}
