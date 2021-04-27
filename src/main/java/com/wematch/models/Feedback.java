package com.wematch.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@Table(name = "feedback")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Feedback{

	// 고객정보, 업체정보, 이사종류(가정이사, 원룸이사),
	// 정보공개동의여부, 전문성 만족도, 친절 만족도,
	// 재방문의사, 계약가격, 이사일, 피드백 작성일, 피드백 내용
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long feedbackId;

	@Column
	private String moveType;
	
	@Column
	private String termsInformationYn;
	
	@Column
	private String satisfactionProfessional;
	
	@Column
	private String satisfactionKindness;
	
	@Column
	private String intentionRevisitYn;
	
	@Column
	private String amountTotal;
	
	@Column
	private String moveDate;
	
	@Column
	private String contents;
	
	@ManyToOne
	private Customer customer;
	
	@OneToOne
	private MovingCompany movingCompany;
}
