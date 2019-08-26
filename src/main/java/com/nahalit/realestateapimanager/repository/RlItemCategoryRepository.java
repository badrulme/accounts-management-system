package com.nahalit.realestateapimanager.repository;

import com.nahalit.realestateapimanager.model.RlItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RlItemCategoryRepository extends JpaRepository<RlItemCategory, Long> {
}
