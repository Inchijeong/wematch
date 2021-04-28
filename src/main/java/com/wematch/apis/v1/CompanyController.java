package com.wematch.apis.v1;

import static com.wematch.apis.dto.ApiResult.succeed;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wematch.apis.dto.ApiResult;
import com.wematch.apis.dto.CompanyDTO;
import com.wematch.models.Company;
import com.wematch.services.CompanyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/companies")
public class CompanyController {

	private final CompanyService companyService;
	
	@GetMapping("")
	public ApiResult<List<CompanyDTO>> getCompanyList(){
		List<Company> companies = companyService.getCompanyList();
		List<CompanyDTO> companyDtoList = companies.stream().map(company -> {
			return CompanyDTO.builder()
				.name(company.getName())
				.tel(company.getTel())
				.address(company.getAddress())
				.isMatching(company.getIsMatching())
				.build();
		}).collect(Collectors.toList());
		
		return succeed(companyDtoList);
	}
	
	@PostMapping("")
	public void registerCompany(@RequestBody Company company){
		companyService.registerCompany(company);
	}
}
