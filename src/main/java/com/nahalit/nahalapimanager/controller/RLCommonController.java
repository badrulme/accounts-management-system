package com.nahalit.nahalapimanager.controller;

import com.nahalit.nahalapimanager.service.RLCommonService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RequestMapping("api/rest/rl/common")
@RestController
public class RLCommonController {

  private final RLCommonService rlCommonService;

  public RLCommonController(RLCommonService rlCommonService) {
    this.rlCommonService = rlCommonService;
  }


}
