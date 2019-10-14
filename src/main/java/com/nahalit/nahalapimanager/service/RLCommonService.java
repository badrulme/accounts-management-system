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

  public String uploadFile(MultipartFile multipartFile) {
    if (multipartFile != null) {
      String nowTime = UtillDate.getNowTimeNameForImage();
      String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename()).replaceAll("(?i)(.+?)(\\.\\w+$)", nowTime + "$2");
      storageService.store(multipartFile, filename);
      return filename;
    }
    return "File Upload Failed";
  }

  public String deleteFile(String fileName) {
    try {
      storageService.deleteFile(fileName);
    } catch (Exception e) {
    }
    return "File Delete Failed";
  }
}
