package com.nahalit.nahalapimanager.repository;

import com.nahalit.nahalapimanager.model.AcVoucher;
import com.nahalit.nahalapimanager.model.AcVoucherdtl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcVoucherdtlRepository extends JpaRepository<AcVoucherdtl, Long> {
    @Query("SELECT V FROM AcVoucher V WHERE V.vNo=:V_NO")
    List<AcVoucherdtl> findAllByVNo(@Param("V_NO") Long V_NO);
}
