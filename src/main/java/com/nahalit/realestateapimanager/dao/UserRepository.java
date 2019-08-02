package com.nahalit.realestateapimanager.dao;

import com.nahalit.realestateapimanager.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
}
