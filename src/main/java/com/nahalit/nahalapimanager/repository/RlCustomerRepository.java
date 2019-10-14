package com.nahalit.nahalapimanager.repository;

import com.nahalit.nahalapimanager.model.RlCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RlCustomerRepository extends JpaRepository<RlCustomer,Long> {
}
