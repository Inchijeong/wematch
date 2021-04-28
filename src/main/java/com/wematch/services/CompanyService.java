package com.wematch.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wematch.models.Company;
import com.wematch.repositories.CompanyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyService {

	private final CompanyRepository companyRepository;
	
	public List<Company> getCompanyList() {		
		List<Company> customers = companyRepository.findAll();
		
		return customers;
	}
	
	public void registerCompany(Company company) {
		companyRepository.save(company);
	}
}
