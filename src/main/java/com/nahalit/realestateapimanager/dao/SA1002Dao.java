package com.nahalit.realestateapimanager.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SA1002Dao {
   List getUserMenu(String menuId, String submenuType, String empNo,String submenuId);
}
