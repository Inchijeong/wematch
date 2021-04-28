package com.wematch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wematch.models.HomeMovingOrder;

@Repository
public interface HomeMovingOrderRepository extends JpaRepository<HomeMovingOrder, Long> {

}
