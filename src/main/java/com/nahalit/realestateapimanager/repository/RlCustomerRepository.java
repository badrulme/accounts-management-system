package com.nahalit.realestateapimanager.repository;

import com.nahalit.realestateapimanager.model.RlCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RlCustomerRepository extends JpaRepository<RlCustomer,Long> {

}
