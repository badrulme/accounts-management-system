package com.nahalit.nahalapimanager.repository;

import com.nahalit.nahalapimanager.model.SaMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaMessageRepository extends JpaRepository<SaMessage, Long> {
}
