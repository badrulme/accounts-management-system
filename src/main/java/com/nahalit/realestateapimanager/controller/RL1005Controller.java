package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlItem;
import com.nahalit.realestateapimanager.model.RlItemInstallment;
import com.nahalit.realestateapimanager.model.RlItemVideo;
import com.nahalit.realestateapimanager.service.RL1005Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/rest/rl/item/ap")
@RestController
public class RL1005Controller {

    private final RL1005Service rL1005Service;

    @Autowired
    public RL1005Controller(RL1005Service RL1005Service) {
        this.rL1005Service = RL1005Service;
    }

    // RL Item Controller
    @GetMapping("/")
    public ResponseEntity<List<RlItem>> getAllItem() {
        return new ResponseEntity<>(this.rL1005Service.getAllApItem(), HttpStatus.OK);
    }

    @GetMapping("/get-item")
    public ResponseEntity<RlItem> getAPItem(@RequestParam Long itemNo){
        return new ResponseEntity<>(this.rL1005Service.getApItem(itemNo),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<RlItem> saveItem(@RequestBody RlItem rlItem) {
        return new ResponseEntity<>(this.rL1005Service.saveApRlItem(rlItem), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<RlItem> updateItem(@RequestBody RlItem reItem) throws ResourceNotFoundException {
        return new ResponseEntity<>(rL1005Service.updateApRlItem(reItem), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteItem(@RequestParam Long itemNo) {
        this.rL1005Service.deleteApRlItem(itemNo);
        return new ResponseEntity<>("Land Item Deleted Successfully.", HttpStatus.OK);
    }
}
