package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.dao.CuItemDao;
import org.springframework.stereotype.Service;

@Service
public class CuItemService {
  private final CuItemDao cuItemDao;

  public CuItemService(CuItemDao cuItemDao) {
    this.cuItemDao = cuItemDao;
  }

}
