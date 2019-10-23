package com.nahalit.nahalapimanager.controller;


import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlCustomer;
import com.nahalit.nahalapimanager.model.RlTrn;
import com.nahalit.nahalapimanager.model.RlTrnNominee;
import com.nahalit.nahalapimanager.model.RlUploadVideo;
import com.nahalit.nahalapimanager.service.RL1019Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/rest/rl/trn")
@RestController
public class RL1019Controller {
    private final RL1019Service rl1019Service;

    public RL1019Controller(RL1019Service rl1019Service) {
        this.rl1019Service = rl1019Service;
    }

    @GetMapping("/")
    public ResponseEntity<List> getAllTrn(@RequestParam(required = false) Long trnNo) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.rl1019Service.getAllTransaction(trnNo), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<RlTrn> saveRlTrn(@RequestBody RlTrn rlTrn) throws ParseException {
        return new ResponseEntity<>(this.rl1019Service.saveRlTrn(rlTrn), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<RlTrn> updateRlTrn(@RequestBody RlTrn rlTrn) throws ResourceNotFoundException, ParseException {
        return new ResponseEntity<>(this.rl1019Service.updateRlTrn(rlTrn), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map> deleteRajukApproval(@RequestParam Long trnNo) {
        return new ResponseEntity<>(this.rl1019Service.deleteRlTrn(trnNo), HttpStatus.OK);
    }

    // RL Item Video Controller
    @GetMapping("/nominee/")
    public ResponseEntity<List<RlTrnNominee>> getAllNominee() {
        return new ResponseEntity<>(this.rl1019Service.getAllNominee(), HttpStatus.OK);
    }

//    @GetMapping("/nominee/get-nominee")
//    public ResponseEntity<RlUploadVideo> getItemVideo(@Valid @RequestParam("nomineeNo") Long nomineeNo) throws ResourceNotFoundException {
//        return new ResponseEntity<>(this.rl1019Service.getRlItemVideo(nomineeNo), HttpStatus.OK);
//    }

    @GetMapping("/nominee/get-nominee-list")
    public ResponseEntity<List<RlTrnNominee>> getNomineeByTrnNo(@Valid @RequestParam("itemNo") String trnNo) {
        return new ResponseEntity<>(this.rl1019Service.getNomineeByTrnNo(trnNo), HttpStatus.OK);
    }

    @PostMapping("/nominee/add")
    public ResponseEntity<RlTrnNominee> saveRlTrnNominee(@RequestBody RlTrnNominee rlTrnNominee) throws ParseException {
        return new ResponseEntity<>(this.rl1019Service.saveRlTrnNominee(rlTrnNominee), HttpStatus.CREATED);
    }

    @PostMapping("/nominee/add-list")
    public ResponseEntity<List<RlTrnNominee>> saveRlTrnNomineeList(@RequestBody List<RlTrnNominee> rlTrnNominees) {
        return new ResponseEntity<>(this.rl1019Service.saveRlTrnNomineeList(rlTrnNominees), HttpStatus.CREATED);
    }

    @PutMapping("/nominee/update")
    public ResponseEntity<RlTrnNominee> updateRlTrnNominee(@RequestBody RlTrnNominee rlTrnNominee) throws ResourceNotFoundException, ParseException {
        return new ResponseEntity<>(this.rl1019Service.updateRlTrnNominee(rlTrnNominee), HttpStatus.ACCEPTED);
    }

    @PutMapping("/nominee/update-list")
    public ResponseEntity<List<RlTrnNominee>> updateRlTrnNomineeList(@RequestBody List<RlTrnNominee> rlTrnNominees) throws ResourceNotFoundException, ParseException {
        return new ResponseEntity<>(this.rl1019Service.updateRlTrnNomineeList(rlTrnNominees), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/nominee/delete")
    public ResponseEntity<Map> deleteRlTrnNominee(@RequestParam Long nomineeNo) {
        return new ResponseEntity<>(this.rl1019Service.deleteRlTrnNominee(nomineeNo), HttpStatus.OK);
    }

    @DeleteMapping("/nominee/delete-list")
    public ResponseEntity<Map> deleteRlTrnNomineeList(@RequestBody List<RlTrnNominee> rlTrnNominees) {
        return new ResponseEntity<>(this.rl1019Service.deleteRlTrnNomineeList(rlTrnNominees), HttpStatus.OK);
    }
}
