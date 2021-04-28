package com.wematch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wematch.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
