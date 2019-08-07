package com.nahalit.realestateapimanager.repository;

import com.nahalit.realestateapimanager.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
