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

	//이름, 연락처, 출발지 주소정보, 출발지 층수,
	//도착지 주소정보, 도착지 층수, 이사일자, 보관이사여부,
	//이용약관동의여부, 견적요청을 위한 개인정보 제3자 제공동의여부,
	//마케팅 정보수신 동의여부
	
	@Column(nullable = false, length = 45)
	private String startAddress;
	
	@Column(nullable = false)
	private Integer startFloor;
	
	@Column(nullable = false, length = 45)
	private String endAddress;
	
	@Column(nullable = false)
	private Integer endFloor;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime movingDate;
	
	@Column(nullable = false, length = 1, columnDefinition = "CHAR(1) DEFAULT 0")
	private Boolean isStorage;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "customer_id")
	private Customer customer;
}
