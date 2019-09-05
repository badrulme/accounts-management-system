package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlItem;
import com.nahalit.realestateapimanager.model.RlItemInstallment;
import com.nahalit.realestateapimanager.model.RlItemVideo;
import com.nahalit.realestateapimanager.service.RL1005Service;
import com.nahalit.realestateapimanager.service.RL1007Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RequestMapping("api/rest/rl/item/land")
@RestController
public class RL1007Controller {

    private final RL1007Service rl1007Service;
    private final RL1005Service rl1005Service;

    public RL1007Controller(RL1007Service rl1007Service, RL1005Service rl1005Service) {
        this.rl1007Service = rl1007Service;
        this.rl1005Service = rl1005Service;
    }

    // RL Item Controller
    @GetMapping("/")
    public ResponseEntity<List<RlItem>> getAllLandItem() {
        return new ResponseEntity<>(this.rl1007Service.getAllLandItem(), HttpStatus.OK);
    }
    @GetMapping("/get-item")
    public ResponseEntity<RlItem> getALandtem(@RequestParam Long itemNo){
        return new ResponseEntity<>(this.rl1007Service.getApItem(itemNo),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<RlItem> saveLandItem(@RequestBody RlItem rlItem) throws ParseException {
        return new ResponseEntity<>(this.rl1007Service.saveLandRlItem(rlItem), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<RlItem> updateLandItem(@RequestBody RlItem reItem) throws ResourceNotFoundException, ParseException {
        return new ResponseEntity<>(rl1007Service.updateLandRlItem(reItem), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteLandItem(@RequestParam Long itemNo) {
        this.rl1007Service.deleteLandRlItem(itemNo);
        return new ResponseEntity<>("Land Item Deleted Successfully.", HttpStatus.OK);
    }
}
