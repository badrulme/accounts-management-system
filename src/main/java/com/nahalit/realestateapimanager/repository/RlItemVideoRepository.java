package com.nahalit.realestateapimanager.repository;

import com.nahalit.realestateapimanager.model.RlItemVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RlItemVideoRepository extends JpaRepository<RlItemVideo, Long> {
}