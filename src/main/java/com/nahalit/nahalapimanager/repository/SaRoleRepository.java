package com.nahalit.nahalapimanager.repository;

import com.nahalit.nahalapimanager.model.SaRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaRoleRepository extends JpaRepository<SaRole, Long> {
}
