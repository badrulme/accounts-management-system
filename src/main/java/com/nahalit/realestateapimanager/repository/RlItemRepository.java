package com.nahalit.realestateapimanager.repository;

import com.nahalit.realestateapimanager.model.RlItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RlItemRepository extends JpaRepository<RlItem, Long> {
    @Query("SELECT I FROM RlItem I WHERE ITEM_TYPE=:ITEM_TYPE")
    List<RlItem> findAllByItemType(@Param("ITEM_TYPE") Long ITEM_TYPE);

    @Query("SELECT I FROM RlItem  I WHERE ITEM_NO=:ITEM_NO AND ITEM_TYPE=:ITEM_TYPE")
    RlItem findItemByIdAndType(@Param("ITEM_NO") Long ITEM_NO, @Param("ITEM_TYPE") Long ITEM_TYPE);
}
