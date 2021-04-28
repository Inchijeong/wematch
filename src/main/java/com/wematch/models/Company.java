package com.wematch.models;

import java.time.LocalDateTime;

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
@Table(name = "company")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Company extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long companyId;

	@Column(nullable = false, length = 20)
	private String name;
	
	@Column(length = 20)
	private String ceo;
	
	@Column(nullable = false, length = 20)
	private String tel;
	
	@Column(nullable = false, length = 45)
	private String address;
	
	@Column(length = 20)
	private String businessNumber;	
	
	@Column
	private LocalDateTime businessRegDate;
	
	@Column
	private Integer employeesCnt;
	
	@Column
	private Integer carCnt;
	
	@Column(nullable = false, length = 1, columnDefinition = "CHAR(1) DEFAULT 'N'")
	@Convert(converter = BooleanToYNConverter.class)
	private Boolean isMatching;
}
