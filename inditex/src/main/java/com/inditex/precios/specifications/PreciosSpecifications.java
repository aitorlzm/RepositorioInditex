package com.inditex.precios.specifications;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

import com.inditex.precios.model.Precios;

import jakarta.persistence.criteria.Predicate;

public class PreciosSpecifications {
	
	public static Specification<Precios> obtenerPreciosPorMarcaYRango(Integer productId, Integer brandId, LocalDateTime startDate) {
		return (root, query, criteriaBuilder) -> {
			Predicate productPredicate = criteriaBuilder.equal(root.get("productId"), productId);
            Predicate brandPredicate = criteriaBuilder.equal(root.get("brandId"), brandId);
            Predicate datePredicate = criteriaBuilder.equal(root.get("startDate"), startDate);

            query.orderBy(criteriaBuilder.desc(root.get("priority")));
			
			return criteriaBuilder.and(productPredicate, brandPredicate, datePredicate);
		};
		
	}

}
