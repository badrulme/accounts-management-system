package com.nahalit.nahalapimanager.controller;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.SaSubmenu;
import com.nahalit.nahalapimanager.service.SA1003Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/rest/sa/sa-submenu")
public class SA1003Controller {

  private final SA1003Service sa1003Service;

  public SA1003Controller(SA1003Service sa1003Service) {
    this.sa1003Service = sa1003Service;
  }

  // SA SUBMENU Controller
  @GetMapping("/")
  public ResponseEntity<List<SaSubmenu>> getAllSaSubmenu() {
    return new ResponseEntity<>(sa1003Service.getAllSaSubmenu(), HttpStatus.OK);
  }

  @GetMapping("/get-sa-submenu")
  public ResponseEntity<SaSubmenu> getSaSubmenu(@Valid @RequestParam("submenuNo") Long submenuNo) throws ResourceNotFoundException {
    return new ResponseEntity<>(sa1003Service.getSaSubmenu(submenuNo), HttpStatus.OK);
  }

  @GetMapping("/sa-menu-list")
  public ResponseEntity<List> getMenuList(@Valid @RequestParam("submenuType") String submenuType){
    return new ResponseEntity<>(this.sa1003Service.getMenuList(submenuType), HttpStatus.OK);
  }

  @GetMapping("/sa-submenu-list")
  public ResponseEntity<List> getAllByMenuNo(@Valid @RequestParam("menuNo") Integer menuNo)  {
    return new ResponseEntity<>(this.sa1003Service.getAllByMenuNo(menuNo), HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<SaSubmenu> saveSaSubmenu(@RequestBody SaSubmenu saSubmenu) throws ParseException {
    return new ResponseEntity<>(sa1003Service.saveSaSubmenu(saSubmenu), HttpStatus.CREATED);
  }

  @PostMapping("/add-list")
  public ResponseEntity<List<SaSubmenu>> saveSaSubmenuList(@RequestBody List<SaSubmenu> saSubmenuList) {
    return new ResponseEntity<>(sa1003Service.saveSaSubmenuList(saSubmenuList), HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<SaSubmenu> updateSaSubmenu(@RequestBody SaSubmenu saSubmenu) throws ResourceNotFoundException, ParseException {
    return new ResponseEntity<>(sa1003Service.updateSaSubmenu(saSubmenu), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<Map> deleteSaSubmenu(@RequestParam Long submenuNo) {
    return new ResponseEntity<>(this.sa1003Service.deleteSaSubmenu(submenuNo), HttpStatus.OK);
  }
}
