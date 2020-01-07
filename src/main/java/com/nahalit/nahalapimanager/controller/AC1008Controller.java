package com.nahalit.nahalapimanager.controller;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.AcVoucher;
import com.nahalit.nahalapimanager.service.AC1008Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = {"api/rest/ac/voucher"})
public class AC1008Controller {
    private final AC1008Service ac1008Service;

    public AC1008Controller(AC1008Service ac1008Service) {
        this.ac1008Service = ac1008Service;
    }

    // Ac Voucher
    @GetMapping("/")
    public ResponseEntity<List<AcVoucher>> getAllAcVoucher() {
        return new ResponseEntity<>(ac1008Service.getAllAcVoucher(), HttpStatus.OK);
    }

    @GetMapping("/get-cost")
    public ResponseEntity<AcVoucher> getAcVoucher(@Valid @RequestParam("costNo") Long costNo) throws ResourceNotFoundException {
        return new ResponseEntity<>(ac1008Service.getAcVoucher(costNo), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AcVoucher> saveAcVoucher(@RequestBody AcVoucher acCost) throws ParseException {
        return new ResponseEntity<>(ac1008Service.saveAcVoucher(acCost), HttpStatus.CREATED);
    }

    @PostMapping("/add-list")
    public ResponseEntity<List<AcVoucher>> saveAcVoucherList(@RequestBody List<AcVoucher> acCostList) {
        return new ResponseEntity<>(ac1008Service.saveAcVoucherList(acCostList), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AcVoucher> updateAcVoucher(@RequestBody AcVoucher acCost) throws ResourceNotFoundException, ParseException {
        return new ResponseEntity<>(ac1008Service.updateAcVoucher(acCost), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map> deleteAcVoucher(@RequestParam Long costNo) {

        return new ResponseEntity<>(this.ac1008Service.deleteAcVoucher(costNo), HttpStatus.OK);
    }

}
