package com.nahalit.realestateapimanager.repository;

import com.nahalit.realestateapimanager.model.RlCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RlCustomerRepository extends JpaRepository<RlCustomer,Long> {

}
