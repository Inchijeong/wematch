package com.wematch.apis.v1;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wematch.models.Customer;
import com.wematch.models.HomeMovingOrder;
import com.wematch.services.MovingOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/moving/orders")
public class MovingOrderController {

	private final MovingOrderService movingOrderService;
	
	@GetMapping("")
	public List<HomeMovingOrder> getHomeMovingOrderList(){
		List<HomeMovingOrder> homeMovingOrder = movingOrderService.getHomeMovingOrderList();
		return homeMovingOrder;
	}
	
	@PostMapping("")
	public void registerHomeMovingOrder(@RequestBody HomeMovingOrder homeMovingOrder){
		movingOrderService.registerHomeMovingOrder(homeMovingOrder);
	}
}
