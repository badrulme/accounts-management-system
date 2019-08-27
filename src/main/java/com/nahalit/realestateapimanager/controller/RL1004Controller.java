package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.model.RlItem;
import com.nahalit.realestateapimanager.service.RL1004Service;
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
public class RL1004Controller {

    private final RL1004Service RL1004Service;

    @Autowired
    public RL1004Controller(RL1004Service RL1004Service) {
        this.RL1004Service = RL1004Service;
    }

    @GetMapping("/")
    public ResponseEntity<List<RlItem>> getAllItem() {
        return new ResponseEntity<>(this.RL1004Service.getAllItem(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<RlItem> saveItem(RlItem rlItem) {
        return new ResponseEntity<>(this.RL1004Service.saveRlItem(rlItem), HttpStatus.CREATED);
    }

}
