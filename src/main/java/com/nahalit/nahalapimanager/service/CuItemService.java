package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.dao.CuItemDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CuItemService {
  private final CuItemDao cuItemDao;

  public CuItemService(CuItemDao cuItemDao) {
    this.cuItemDao = cuItemDao;
  }

  public List getItemList(String itemNo, String itemTypeNo, String itemName, String bedRoom, String priceFrom, String priceTo, String sizeFrom, String sizeTo, String projectLocation,String itemNoList) {
    return this.cuItemDao.getItemList(itemNo, itemTypeNo, itemName, bedRoom, priceFrom, priceTo, sizeFrom, sizeTo, projectLocation,itemNoList);
  }

  public Map getItemDetails(Long itemNo) {
    return this.cuItemDao.getItemDetails(itemNo);
  }

}
