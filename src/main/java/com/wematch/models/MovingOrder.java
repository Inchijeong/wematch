package com.wematch.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;

@Getter
@MappedSuperclass
public abstract class MovingOrder extends BaseEntity{
	
	@Column(nullable = false, length = 45)
	protected String startAddress;
	
	@Column(nullable = false)
	protected Integer startFloor;
	
	@Column(nullable = false, length = 45)
	protected String endAddress;
	
	@Column(nullable = false)
	protected Integer endFloor;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	protected LocalDateTime movingDate;
	
	@Column(nullable = false, length = 1, columnDefinition = "CHAR(1) DEFAULT 0")
	protected Boolean isStorage;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "customer_id")
	protected Customer customer;
}
