package com.wematch.apis.dto;

import com.wematch.models.Customer;
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
public class CustomerDTO {
	
	private String name;
	private String tel;
    
    @Builder
	public CustomerDTO(String name, String tel) {
		this.name = name;
		this.tel = TelUtils.changeSecretNumber(tel);
	}
	
	public Customer toEntity() {
		return Customer.builder()
				.name(this.name)
				.tel(this.tel)
				.build();
	}
}
