package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlItemVideo;
import com.nahalit.realestateapimanager.service.RlItemVideoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/rest/rl/item/video")
@RestController
public class RlItemVideoController {
    private final RlItemVideoService rlItemVideoService;

    public RlItemVideoController(RlItemVideoService rlItemVideoService) {
        this.rlItemVideoService = rlItemVideoService;
    }

    // RL Item Video Controller
    @GetMapping("/")
    public ResponseEntity<List<RlItemVideo>> getAllRlItemVideo() {
        return new ResponseEntity<>(this.rlItemVideoService.getAllRlItemVideo(), HttpStatus.OK);
    }

    @GetMapping("/get-item-video")
    public ResponseEntity<RlItemVideo> getItemVideo(@Valid @RequestParam("videoNo") Long installmentNo) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.rlItemVideoService.getRlItemVideo(installmentNo), HttpStatus.OK);
    }

    @GetMapping("/get-item-video-list")
    public ResponseEntity<List<RlItemVideo>> getAllRlItemVideoList(@Valid @RequestParam Long itemNo) {
        return new ResponseEntity<>(this.rlItemVideoService.getRlItemVideoList(itemNo), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<RlItemVideo> saveItemVideo(@RequestBody RlItemVideo reItemVideo) {
        return new ResponseEntity<>(this.rlItemVideoService.saveRlItemVideo(reItemVideo), HttpStatus.CREATED);
    }

    @PostMapping("/add-list")
    public ResponseEntity<List<RlItemVideo>> saveItemVideoList(@RequestBody List<RlItemVideo> rlItemVideos) {
        return new ResponseEntity<>(this.rlItemVideoService.saveRlItemVideoList(rlItemVideos), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<RlItemVideo> updateItemVideo(@RequestBody RlItemVideo reItemVideo) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.rlItemVideoService.updateRlItemVideo(reItemVideo), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteVideo(@RequestParam Long installmentNo) {
        this.rlItemVideoService.deleteRlItemVideo(installmentNo);
        return new ResponseEntity<>("Item Video Deleted Successfully.", HttpStatus.OK);
    }
}
