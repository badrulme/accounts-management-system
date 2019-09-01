package com.nahalit.realestateapimanager.repository;

import com.nahalit.realestateapimanager.model.RlRajukApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RlRajukApprovalRepository extends JpaRepository<RlRajukApproval,Long> {
}
