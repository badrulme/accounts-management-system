package com.nahalit.realestateapimanager.repository;

import com.nahalit.realestateapimanager.model.RlFacing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RlFacingRepository extends JpaRepository<RlFacing, Long> {
}
