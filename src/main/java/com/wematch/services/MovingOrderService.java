package com.wematch.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wematch.models.HomeMovingOrder;
import com.wematch.repositories.HomeMovingOrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovingOrderService {

	private final HomeMovingOrderRepository homeMovingOrderRepository;
	
	public List<HomeMovingOrder> getHomeMovingOrderList() {		
		List<HomeMovingOrder> homeMovingOrder = homeMovingOrderRepository.findAll();
		
		return homeMovingOrder;
	}
	
	public void registerHomeMovingOrder(HomeMovingOrder homeMovingOrder) {
		homeMovingOrderRepository.save(homeMovingOrder);
	}
}
