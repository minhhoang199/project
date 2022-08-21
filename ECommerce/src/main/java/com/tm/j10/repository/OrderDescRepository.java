package com.tm.j10.repository;

import com.tm.j10.domain.OrderDesc;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the OrderDesc entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrderDescRepository extends JpaRepository<OrderDesc, Long> {}
