package com.wematch.apis.v1;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wematch.models.Company;
import com.wematch.services.CompanyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/companies")
public class CompanyController {

	private final CompanyService companyService;
	
	@GetMapping("")
	public List<Company> getCompanyList(){
		List<Company> company = companyService.getCompanyList();
		return company;
	}
	
	@PostMapping("")
	public void registerCompany(@RequestBody Company company){
		companyService.registerCompany(company);
	}
}
