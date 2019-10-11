package com.nahalit.nahalapimanager.controller;

import com.nahalit.nahalapimanager.AppResponse;
import com.nahalit.nahalapimanager.constant.KEY;
import com.nahalit.nahalapimanager.dao.CoreCommonRepo;
import com.nahalit.nahalapimanager.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController(value = "coreCommonController")
@RequestMapping(value = { "/core/common"}, method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE})
public class CoreCommonController {
  private @Autowired
  HttpServletRequest request;
  private @Autowired
  CoreCommonRepo commonRepo;
  private @Autowired
  AuthService authService;

  @RequestMapping("/get-menu")
  public AppResponse getMenu(@RequestParam(value = KEY.MENU_TYPE) String menuType  ) {
    return AppResponse.build(HttpStatus.OK).body(commonRepo.getMenu(authService.getCompanyNo(), authService.getUserNo(),menuType));
  }
}
