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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	@Column(nullable = false, length = 50)
	private String name;
	
	@Column(nullable = false, length = 20)
	private String tel;
	
	@Column(nullable = false, length = 1, columnDefinition = "CHAR(1) DEFAULT 'N'")
	@Convert(converter = BooleanToYNConverter.class)
	private Boolean isServiceTerms;
	
	@Column(nullable = false, length = 1, columnDefinition = "CHAR(1) DEFAULT 'N'")
	@Convert(converter = BooleanToYNConverter.class)
	private Boolean isPrivacyTerms;
	
	@Column(nullable = false, length = 1, columnDefinition = "CHAR(1) DEFAULT 'N'")
	@Convert(converter = BooleanToYNConverter.class)
	private Boolean isMarketingTerms;
}
