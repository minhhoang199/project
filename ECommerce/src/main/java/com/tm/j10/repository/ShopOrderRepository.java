package com.tm.j10.repository;

import com.tm.j10.domain.ShopOrder;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ShopOrder entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ShopOrderRepository extends JpaRepository<ShopOrder, Long> {}
