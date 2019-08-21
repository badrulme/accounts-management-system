package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlItemVideo;
import com.nahalit.realestateapimanager.service.RlItemVideoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/rest/rl/item-video")
@RestController
public class RlItemVideoController {
    private final RlItemVideoService rlItemVideoService;

    public RlItemVideoController(RlItemVideoService rlItemVideoService) {
        this.rlItemVideoService = rlItemVideoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<RlItemVideo>> getAllRlItemVideo() {
        return new ResponseEntity<>(rlItemVideoService.getAllRlItemVideo(), HttpStatus.OK);
    }

    @GetMapping("/get-item-category")
    public ResponseEntity<RlItemVideo> getItemVideo(@Valid @RequestParam("videoNo") Long installmentNo) throws ResourceNotFoundException {
        return new ResponseEntity<>(rlItemVideoService.getRlItemVideo(installmentNo), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<RlItemVideo> saveItemVideo(RlItemVideo reItemVideo) {
        return new ResponseEntity<>(rlItemVideoService.saveRlItemVideo(reItemVideo), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<RlItemVideo> updateItemVideo(RlItemVideo reItemVideo) throws ResourceNotFoundException {
        return new ResponseEntity<>(rlItemVideoService.updateRlItemVideo(reItemVideo), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteVideo(@RequestParam Long installmentNo) {
        this.rlItemVideoService.deleteRlItemVideo(installmentNo);
        return new ResponseEntity<>("Item Video Deleted Successfully.", HttpStatus.OK);
    }
}
