package com.nahalit.realestateapimanager.repository;

import com.nahalit.realestateapimanager.model.RlItemVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RlItemVideoRepository extends JpaRepository<RlItemVideo, Long> {
    @Query("SELECT V FROM RlItemVideo V WHERE ITEM_NO=:ITEM_NO")
    List<RlItemVideo> findAllByItemNo(@Param("ITEM_NO") Long itemNo);
}
