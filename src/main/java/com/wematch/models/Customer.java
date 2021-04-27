package com.wematch.models;

import javax.persistence.Column;
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
@Table(name = "customer")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer{

	//이름, 연락처, 등록일, 이용약관동의여부,
	// 견적요청을 위한 개인정보 제3자 제공동의여부, 마케팅 정보수신 동의여부
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	@Column
	private String name;
	
	@Column
	private String phoneNumber;
	
	@Column
	private String termsServiceYn;
	
	@Column
	private String termsPrivacyYn;
	
	@Column
	private String termsMarketingYn;
}
