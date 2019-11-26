package com.nahalit.nahalapimanager.repository;

import com.nahalit.nahalapimanager.model.SaSubregion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaSubregionRepository extends JpaRepository<SaSubregion, Long> {
}
