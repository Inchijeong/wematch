package com.wematch.apis.v1;

import static com.wematch.apis.dto.ApiResult.succeed;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wematch.apis.dto.ApiResult;
import com.wematch.apis.dto.HomeMovingOrderDTO;
import com.wematch.models.HomeMovingOrder;
import com.wematch.services.MovingOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/moving/orders")
public class MovingOrderController {

	private final MovingOrderService movingOrderService;
	
	@GetMapping("")
	public ApiResult<List<HomeMovingOrderDTO>> getHomeMovingOrderList(){
		List<HomeMovingOrder> homeMovingOrders = movingOrderService.getHomeMovingOrderList();
		
		List<HomeMovingOrderDTO> orderDtoList = homeMovingOrders
				.stream()
				.map(HomeMovingOrderDTO::new)
				.collect(Collectors.toList());
		return succeed(orderDtoList);
	}
	
	@PostMapping("")
	public void registerHomeMovingOrder(@RequestBody HomeMovingOrder homeMovingOrder){
		movingOrderService.registerHomeMovingOrder(homeMovingOrder);
	}
}
