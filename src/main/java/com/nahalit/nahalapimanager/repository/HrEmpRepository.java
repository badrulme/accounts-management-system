package com.nahalit.nahalapimanager.repository;

import com.nahalit.nahalapimanager.model.HrEmp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HrEmpRepository  extends JpaRepository<HrEmp,Long> {
}
