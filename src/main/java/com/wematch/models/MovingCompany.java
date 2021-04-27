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
@Table(name = "moving_company")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class MovingCompany{

	//업체명, 대표이사, 연락처, 주소정보, 사업자번호
	//사업자등록일자, 직원수, 차량수(1톤, 2.5톤, 5톤, 기타)
	//매칭가능여부
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long movingCompanyId;

	@Column
	private String ceo;
	
	@Column
	private String phoneNumber;
	
	@Column
	private String address;
	
	@Column
	private String businessNumber;	
	
	@Column
	private String businessRegDate;
	
	@Column
	private String employeesCnt;
	
	@Column
	private String carCnt;
	
	@Column
	private String matchCnt;
}
