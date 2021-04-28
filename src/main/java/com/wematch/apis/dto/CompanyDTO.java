package com.wematch.apis.dto;

import com.wematch.models.Company;
import com.wematch.utils.TelUtils;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class CompanyDTO {
	
	private String name;
	private String tel;
	private String address;
	private Boolean isMatching;
	
    @Builder
	public CompanyDTO(String name, String tel, String address, Boolean isMatching) {
		this.name = name;
		this.tel = TelUtils.changeSecretNumber(tel);
		this.address = address;
		this.isMatching = isMatching;
	}
	
	public Company toEntity() {
		return Company.builder()
				.name(this.name)
				.tel(this.tel)
				.address(this.address)
				.isMatching(this.isMatching)
				.build();
	}
}
