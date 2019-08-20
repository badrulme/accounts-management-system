package com.nahalit.realestateapimanager.repository;

import com.nahalit.realestateapimanager.model.RlItemSlider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RlItemSliderRepository extends JpaRepository<RlItemSlider, Long> {
}
