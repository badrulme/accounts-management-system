package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.storage.StorageService;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class RLCommonService {
  private final StorageService storageService;

  public RLCommonService(StorageService storageService) {
    this.storageService = storageService;
  }


}
