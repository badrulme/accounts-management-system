package com.nahalit.nahalapimanager.repository;

import com.nahalit.nahalapimanager.model.RlItemSize;
import com.nahalit.nahalapimanager.model.SaSubregion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface SaSubregionRepository extends JpaRepository<SaSubregion, Long> {
  @Query("SELECT R FROM SaSubregion R WHERE R.regionNo=:REGION_NO")
  List<SaSubregion> getAllByRegionNo(@RequestParam("REGION_NO") Long REGION_NO);
}
