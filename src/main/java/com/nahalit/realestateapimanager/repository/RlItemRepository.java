package com.nahalit.realestateapimanager.repository;

import com.nahalit.realestateapimanager.model.RlItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RlItemRepository extends JpaRepository<Long, RlItem> {
}
