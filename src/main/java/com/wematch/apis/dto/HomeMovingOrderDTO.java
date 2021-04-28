package com.wematch.apis.dto;

import java.time.LocalDateTime;

import com.wematch.models.Customer;
import com.wematch.models.HomeMovingOrder;
import com.wematch.utils.TelUtils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class HomeMovingOrderDTO {
	
	private String name;
	private String tel;
	private String startAddress;
	private Integer startFloor;
	private String endAddress;
	private Integer endFloor;
	private LocalDateTime movingDate;
	private Boolean isStorage;
	
	public HomeMovingOrderDTO(HomeMovingOrder entity) {
    	Customer customer = entity.getCustomer();
		this.name = customer.getName();
		this.tel = TelUtils.changeSecretNumber(customer.getTel());
		this.startAddress = entity.getStartAddress();
		this.startFloor = entity.getStartFloor();
		this.endAddress = entity.getEndAddress();
		this.endFloor = entity.getEndFloor();
		this.movingDate = entity.getMovingDate();
		this.isStorage = entity.getIsStorage();
	}
	
	public Customer toEntity() {
		return Customer.builder()
				.name(this.name)
				.tel(this.tel)
				.build();
	}
}
