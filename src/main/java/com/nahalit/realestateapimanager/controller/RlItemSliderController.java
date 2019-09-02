package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlItemSlider;
import com.nahalit.realestateapimanager.service.RlItemSliderService;
import com.nahalit.realestateapimanager.storage.StorageService;
import com.nahalit.realestateapimanager.utillibrary.UtillDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/rest/rl/item/slider")
@RestController
public class RlItemSliderController {
    private final RlItemSliderService rlItemSliderService;
    private final StorageService storageService;

    public RlItemSliderController(RlItemSliderService rlItemSliderService, StorageService storageService) {
        this.rlItemSliderService = rlItemSliderService;
        this.storageService = storageService;
    }

    // RL Item Slider Controller
    @GetMapping("/")
    public ResponseEntity<List<RlItemSlider>> getAllRlItemSlider() {
        return new ResponseEntity<>(this.rlItemSliderService.getAllRlItemSlider(), HttpStatus.OK);
    }

    @GetMapping("/get-item-Slider")
    public ResponseEntity<RlItemSlider> getItemSlider(@Valid @RequestParam("SliderNo") Long installmentNo) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.rlItemSliderService.getRlItemSlider(installmentNo), HttpStatus.OK);
    }

    @GetMapping("/get-item-Slider-list")
    public ResponseEntity<List<RlItemSlider>> getAllRlItemSliderList(@Valid @RequestParam Long itemNo) {
        return new ResponseEntity<>(this.rlItemSliderService.getRlItemSliderList(itemNo), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<RlItemSlider> saveItemSlider(@RequestParam MultipartFile multipartFile, RlItemSlider rlItemSlider) {
        if (multipartFile != null) {
            String nowTime = UtillDate.getNowTimeNameForImage();
            String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename()).replaceAll("(?i)(.+?)(\\.\\w+$)", nowTime + "$2");
            storageService.store(multipartFile, filename);
            rlItemSlider.setImageName(filename);
        }
        return new ResponseEntity<>(this.rlItemSliderService.saveRlItemSlider(rlItemSlider), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteSlider(@RequestParam Long sliderNo) {
        this.rlItemSliderService.deleteRlItemSlider(sliderNo);
        return new ResponseEntity<>("Item Slider Deleted Successfully.", HttpStatus.OK);
    }
}
