package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.dao.RLItemDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CuItemService {
  private final RLItemDao rlItemDao;

  public CuItemService(RLItemDao rlItemDao) {
    this.rlItemDao = rlItemDao;
  }

  public List getItemList(String itemNo, String itemTypeNo, String itemName, String bedRoom, String priceFrom, String priceTo, String sizeFrom, String sizeTo, String projectLocation,String itemNoList) {
    return this.rlItemDao.getItemList(itemNo, itemTypeNo, itemName, bedRoom, priceFrom, priceTo, sizeFrom, sizeTo, projectLocation,itemNoList);
  }

  public Map getItemDetails(String itemNo) {
    return this.rlItemDao.getItemDetails(itemNo);
  }
}
