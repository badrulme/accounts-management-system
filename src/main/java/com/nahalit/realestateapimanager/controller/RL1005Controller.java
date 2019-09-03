package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlItem;
import com.nahalit.realestateapimanager.model.RlItemInstallment;
import com.nahalit.realestateapimanager.model.RlItemSize;
import com.nahalit.realestateapimanager.model.RlItemVideo;
import com.nahalit.realestateapimanager.service.RL1005Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.basic.BasicScrollPaneUI;
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
    public ResponseEntity<RlItem> getAPItem(@RequestParam Long itemNo) {
        return new ResponseEntity<>(this.rL1005Service.getApItem(itemNo), HttpStatus.OK);
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

    // Flat Type Wise Size setup
    @GetMapping("/size/")
    public ResponseEntity<List<RlItemSize>> getAllItemSize() {
        return new ResponseEntity<>(this.rL1005Service.getAllItemSize(), HttpStatus.OK);
    }

    @GetMapping("/size/get-item-size")
    public ResponseEntity<RlItemSize> getItemSize(@RequestParam Long sizeNo) {
        return new ResponseEntity<>(this.rL1005Service.getItemSize(sizeNo), HttpStatus.OK);
    }

    @GetMapping("/size/get-item-size-list")
    public ResponseEntity<List<RlItemSize>> getItemSizeList(@RequestParam Long projectNo) {
        return new ResponseEntity<>(this.rL1005Service.getAllItemSizeList(projectNo), HttpStatus.OK);
    }

    @PostMapping("/size/add")
    public ResponseEntity<RlItemSize> saveItemSize(@RequestBody RlItemSize rlItemSize) {
        return new ResponseEntity<>(this.rL1005Service.saveItemSize(rlItemSize), HttpStatus.CREATED);
    }

    @PostMapping("/size/add-list")
    public ResponseEntity<List<RlItemSize>> saveItemSizeList(@RequestBody List<RlItemSize> rlItemSizes) {
        return new ResponseEntity<>(this.rL1005Service.saveItemSizeList(rlItemSizes), HttpStatus.CREATED);
    }

    @PutMapping("/size/update")
    public ResponseEntity<RlItemSize> updateItemSize(@RequestBody RlItemSize rlItemSize) {
        return new ResponseEntity<>(this.rL1005Service.updateItemSize(rlItemSize), HttpStatus.ACCEPTED);
    }

    @PutMapping("/size/update-list")
    public ResponseEntity<List<RlItemSize>> updateItemSizeList(@RequestBody List<RlItemSize> rlItemSizes) {
        return new ResponseEntity<>(this.rL1005Service.updateItemSizeList(rlItemSizes), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/size/delete")
    public ResponseEntity<String> deleteItemSize(@RequestParam Long sizeNo) {
        this.rL1005Service.deleteItemSize(sizeNo);
        return new ResponseEntity<>("Item size deleted successfully.", HttpStatus.OK);
    }

    @DeleteMapping("/size/delete-list")
    public ResponseEntity<String> deleteItemSizeList(@RequestBody List<RlItemSize> rlItemSizes) {
        this.rL1005Service.deleteItemSizeList(rlItemSizes);
        return new ResponseEntity<>("Item size deleted successfully.", HttpStatus.OK);
    }
}
