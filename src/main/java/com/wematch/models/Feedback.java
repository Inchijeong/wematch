package com.wematch.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.wematch.utils.BooleanToYNConverter;

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
public class Feedback extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long feedbackId;

	@Column(nullable = false, length = 1, columnDefinition = "CHAR(1) DEFAULT 0")
	private String movingType;
	
	@Column(nullable = false, length = 1, columnDefinition = "CHAR(1) DEFAULT 0")
	@Convert(converter = BooleanToYNConverter.class)
	private Boolean isInformationTerms;
	
	@Column
	private Integer satisfactionProfessional;
	
	@Column
	private Integer satisfactionKindness;
	
	@Column(nullable = false, length = 1, columnDefinition = "CHAR(1) DEFAULT 0")
	@Convert(converter = BooleanToYNConverter.class)
	private Boolean isIntentionRevisit;
	
	@Column
	private Integer totalPrice;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime movingDate;
	
	@Column(columnDefinition = "TEXT")
	private String contents;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name = "company_id")
	private Company Company;
}
