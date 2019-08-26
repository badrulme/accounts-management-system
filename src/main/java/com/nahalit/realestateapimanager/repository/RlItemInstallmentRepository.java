package com.nahalit.realestateapimanager.repository;

import com.nahalit.realestateapimanager.model.RlItemInstallment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RlItemInstallmentRepository extends JpaRepository<RlItemInstallment, Long> {
}
