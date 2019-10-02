package com.nahalit.nahalapimanager.repository;

import com.nahalit.nahalapimanager.model.RlContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RlContactRepository  extends JpaRepository<RlContact,Long> {
}
