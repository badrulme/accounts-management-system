package com.nahalit.realestateapimanager.repository;

import com.nahalit.realestateapimanager.model.RlProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RlProjectRepository extends JpaRepository<RlProject, Long> {
    @Query("SELECT p FROM RlProject p WHERE PROJECT_TYPE = :PROJECT_TYPE")
    List<RlProject> findByProjectCategory(@Param("PROJECT_TYPE") Long PROJECT_TYPE);
}
