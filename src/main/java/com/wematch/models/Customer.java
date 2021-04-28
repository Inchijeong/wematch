package com.wematch.models;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wematch.utils.BooleanToYNConverter;

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
public class Customer extends BaseEntity{

	//이름, 연락처, 등록일, 이용약관동의여부,
	// 견적요청을 위한 개인정보 제3자 제공동의여부, 마케팅 정보수신 동의여부
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	@Column(nullable = false, length = 50)
	private String name;
	
	@Column(nullable = false, length = 20)
	private String tel;
	
	@Column(nullable = false, length = 1, columnDefinition = "CHAR(1) DEFAULT 0")
//	@Convert(converter = BooleanToYNConverter.class)
	private Boolean isServiceTerms;
	
	@Column(nullable = false, length = 1, columnDefinition = "CHAR(1) DEFAULT 0")
	private Boolean isPrivacyTerms;
	
	@Column(nullable = false, length = 1, columnDefinition = "CHAR(1) DEFAULT 0")
	private Boolean isMarketingTerms;
}
