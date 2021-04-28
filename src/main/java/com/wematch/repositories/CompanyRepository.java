package com.wematch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wematch.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
