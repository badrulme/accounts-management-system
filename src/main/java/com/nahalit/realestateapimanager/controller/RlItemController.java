package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.model.RlItem;
import com.nahalit.realestateapimanager.model.RlItemCategory;
import com.nahalit.realestateapimanager.service.RlItemService;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/rest/rl/item")
@RestController
public class RlItemController {

    private final RlItemService rlItemService;

    @Autowired
    public RlItemController(RlItemService rlItemService) {
        this.rlItemService = rlItemService;
    }

    @GetMapping("/")
    public ResponseEntity<List<RlItem>> getAllItem() {
        return new ResponseEntity<>(this.rlItemService.getAllItem(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<RlItem> saveItem(RlItem rlItem) {
        return new ResponseEntity<>(this.rlItemService.saveRlItem(rlItem), HttpStatus.CREATED);
    }

}
