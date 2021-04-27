package com.wematch.models;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.Getter;

@Getter
@MappedSuperclass
public abstract class Order extends BaseEntity{

	//이름, 연락처, 출발지 주소정보, 출발지 층수,
	//도착지 주소정보, 도착지 층수, 이사일자, 보관이사여부,
	//이용약관동의여부, 견적요청을 위한 개인정보 제3자 제공동의여부,
	//마케팅 정보수신 동의여부
//	@Column
//	private String phoneNumber;
	
	@Column
	private String startAddress;
	
	@Column
	private String startFloor;
	
	@Column
	private String endAddress;
	
	@Column
	private String endFloor;
	
	@Column
	private String moveDate;
	
	@Column
	private String storeMoveYn;
	
//	@Column
//	private String termsOfService;
//	
//	@Column
//	private String termsOfPrivacy;
//	
//	@Column
//	private String termsOfMarketing;
	
	@ManyToOne
	private Customer customer;
}
