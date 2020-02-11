package com.nahalit.nahalapimanager.repository;

import com.nahalit.nahalapimanager.model.SaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaUserRepository extends JpaRepository<SaUser, Long> {
}
