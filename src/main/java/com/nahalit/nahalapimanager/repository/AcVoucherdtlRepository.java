package com.nahalit.nahalapimanager.repository;

import com.nahalit.nahalapimanager.model.AcVoucherdtl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcVoucherdtlRepository extends JpaRepository<AcVoucherdtl, Long> {
}
