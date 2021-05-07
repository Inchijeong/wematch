package com.wematch.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@Table(name = "home_moving_order")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class HomeMovingOrder extends MovingOrder{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long homeMovingOrderId;

	@Builder
	public HomeMovingOrder(
			Customer customer,
			String startAddress,
			Integer startFloor,
			String endAddress,
			Integer endFloor,
			LocalDateTime movingDate,
			Boolean isStorage) {
		this.customer = customer;
		super.startAddress = startAddress;
		super.startFloor = startFloor;
		super.endAddress = endAddress;
		super.endFloor = endFloor;
		super.movingDate = movingDate;
		super.isStorage = isStorage;
	}
}
