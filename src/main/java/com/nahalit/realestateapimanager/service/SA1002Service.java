package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.dao.SA1002Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SA1002Service {
    private  SA1002Dao  sa1002Dao;

    public SA1002Service(SA1002Dao sa1002Dao) {
        this.sa1002Dao = sa1002Dao;
    }

    public List getUserMenu(String menuId, String submenuType, String empNo){
        return this.sa1002Dao.getUserMenu(menuId,submenuType,empNo);
    }
}
