package com.nahalit.nahalapimanager.controller;

import com.nahalit.nahalapimanager.AppResponse;
import com.nahalit.nahalapimanager.apiconfig.AppConfig;
import com.nahalit.nahalapimanager.constant.KEY;
import com.nahalit.nahalapimanager.dao.AuthRepo;
import com.nahalit.nahalapimanager.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController(value = "coreAuthController")
@RequestMapping(value = {"/core/auth"}, method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
public class AuthController {
  private @Autowired
  HttpServletRequest request;
  private @Autowired
  HttpServletResponse response;

  @Autowired
  AuthRepo authRepo;

  @RequestMapping("/companies")
  public AppResponse companyList(
      @RequestParam(value = KEY.USER_NAME) String userName) {
    return AppResponse.build(HttpStatus.OK).body(authRepo.findAllCompanyByUserName(userName));
  }

//  @RequestMapping("/login")
//  public void login(@RequestParam(value = KEY.USER_NAME) String userName){
//    System.out.println(userName);
//  }
  @RequestMapping("/login")
  public AppResponse login(
      @RequestParam(value = KEY.USER_NAME) String userName,
      @RequestParam(value = KEY.PASSWORD) String password,
      @RequestParam(value = KEY.COMPANY_NO) Long companyNo) {

    User user = authRepo.findUser(userName, password, companyNo);
    if (user != null) {
      user.setPASSWORD(null);
      String token = Jwts.builder()
          .setId(user.getSESSION_KEY())
//          .setIssuer(String.valueOf(user.getUSER_NO()))
          .setIssuer(String.valueOf(user.getEMP_NO()))
          .setAudience(String.valueOf(user.getCOMPANY_NO()))
          .setIssuedAt(Calendar.getInstance().getTime())
          .setNotBefore(Calendar.getInstance().getTime())
          .setIssuedAt(new Date())
          .signWith(SignatureAlgorithm.HS256, AppConfig.APPLICATION_JWT_PRIVATE_KEY)
          .compact();
      Map<String, String> header = new HashMap<>();
      header.put(KEY.TOKEN, token);
      return AppResponse.build(HttpStatus.OK).body(user).message("Login successfully").header(header);
    } else {
      return AppResponse.build(HttpStatus.UNAUTHORIZED).message("Not valid user");
    }
  }

  @RequestMapping("/logout")
  public AppResponse logout() {
    return AppResponse.build(HttpStatus.NOT_IMPLEMENTED).message("Not implemented");
  }
}
