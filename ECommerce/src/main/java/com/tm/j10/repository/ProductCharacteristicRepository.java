package com.tm.j10.repository;

import com.tm.j10.domain.ProductCharacteristic;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ProductCharacteristic entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductCharacteristicRepository extends JpaRepository<ProductCharacteristic, Long> {}
