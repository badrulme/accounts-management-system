package com.nahalit.nahalapimanager.controller;

import com.nahalit.nahalapimanager.service.CuItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("api/rest/rl/cu/item")
@RestController
public class CuItemController {
  private final CuItemService cuItemService;

  public CuItemController(CuItemService cuItemService) {
    this.cuItemService = cuItemService;
  }

  @GetMapping("/")
  public ResponseEntity<List> getItemList(@RequestParam(required = false) String itemNo,
                                          @RequestParam(required = false) String itemTypeNo,
                                          @RequestParam(required = false) String itemName,
                                          @RequestParam(required = false) String bedRoom,
                                          @RequestParam(required = false) String priceFrom,
                                          @RequestParam(required = false) String priceTo,
                                          @RequestParam(required = false) String sizeFrom,
                                          @RequestParam(required = false) String sizeTo,
                                          @RequestParam(required = false) String projectLocation) {
    return new ResponseEntity<>(this.cuItemService.getItemList(itemNo, itemTypeNo, itemName, bedRoom, priceFrom, priceTo, sizeFrom, sizeTo, projectLocation), HttpStatus.OK);
  }

  @GetMapping("/details")
  public ResponseEntity<Map>getItemDetails(@RequestParam Long itemNo){
return new ResponseEntity<>(this.cuItemService.getItemDetails(itemNo),HttpStatus.OK);
  }
}
