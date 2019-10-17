package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.dao.RLItemDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CuItemService {
  private final RLItemDao RLItemDao;

  public CuItemService(RLItemDao RLItemDao) {
    this.RLItemDao = RLItemDao;
  }

  public List getItemList(String itemNo, String itemTypeNo, String itemName, String bedRoom, String priceFrom, String priceTo, String sizeFrom, String sizeTo, String projectLocation,String itemNoList,String projectNo) {
    return this.RLItemDao.getItemList(itemNo, itemTypeNo, itemName, bedRoom, priceFrom, priceTo, sizeFrom, sizeTo, projectLocation,itemNoList,projectNo);
  }

  public Map getItemDetails(String itemNo) {
    return this.RLItemDao.getItemDetails(itemNo);
  }

}
