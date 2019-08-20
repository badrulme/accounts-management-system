package com.nahalit.realestateapimanager.repository;

import com.nahalit.realestateapimanager.model.RlItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RlItemRepository extends JpaRepository<RlItem, Long> {
}
