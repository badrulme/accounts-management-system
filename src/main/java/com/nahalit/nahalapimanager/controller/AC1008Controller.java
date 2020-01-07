package com.nahalit.nahalapimanager.controller;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.AcVoucher;
import com.nahalit.nahalapimanager.model.AcVoucherdtl;
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
    @GetMapping("/voucher/")
    public ResponseEntity<List<AcVoucher>> getAllAcVoucher() {
        return new ResponseEntity<>(ac1008Service.getAllAcVoucher(), HttpStatus.OK);
    }

    @GetMapping("/voucher/get-cost")
    public ResponseEntity<AcVoucher> getAcVoucher(@Valid @RequestParam("costNo") Long costNo) throws ResourceNotFoundException {
        return new ResponseEntity<>(ac1008Service.getAcVoucher(costNo), HttpStatus.OK);
    }

    @PostMapping("/voucher/add")
    public ResponseEntity<AcVoucher> saveAcVoucher(@RequestBody AcVoucher acCost) throws ParseException {
        return new ResponseEntity<>(ac1008Service.saveAcVoucher(acCost), HttpStatus.CREATED);
    }

    @PostMapping("/voucher/add-list")
    public ResponseEntity<List<AcVoucher>> saveAcVoucherList(@RequestBody List<AcVoucher> acCostList) {
        return new ResponseEntity<>(ac1008Service.saveAcVoucherList(acCostList), HttpStatus.CREATED);
    }

    @PutMapping("/voucher/update")
    public ResponseEntity<AcVoucher> updateAcVoucher(@RequestBody AcVoucher acCost) throws ResourceNotFoundException, ParseException {
        return new ResponseEntity<>(ac1008Service.updateAcVoucher(acCost), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/voucher/delete")
    public ResponseEntity<Map> deleteAcVoucher(@RequestParam Long costNo) {

        return new ResponseEntity<>(this.ac1008Service.deleteAcVoucher(costNo), HttpStatus.OK);
    }


    // AC Voucher DTL
    @GetMapping("/voucherdtl/")
    public ResponseEntity<List<AcVoucherdtl>> getAllAcVoucherdtl() {
        return new ResponseEntity<>(this.ac1008Service.getAllAcVoucherdtl(), HttpStatus.OK);
    }


    @GetMapping("/voucherdtl/list")
    public ResponseEntity<List<AcVoucherdtl>> getAllAcVoucherdtlList(@RequestParam Long vNo) {
        return new ResponseEntity<>(this.ac1008Service.getAllAcVoucherdtlList(vNo), HttpStatus.OK);
    }

    @GetMapping("/voucherdtl/get-voucherdtl")
    public ResponseEntity<AcVoucherdtl> getAcVoucherdtl(@RequestParam Long vdtlNo) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.ac1008Service.getAcVoucherdtl(vdtlNo), HttpStatus.OK);
    }

    @PostMapping("/voucherdtl/add")
    public ResponseEntity<AcVoucherdtl> saveAcVoucherdtl(@RequestBody AcVoucherdtl acVoucherdtl) throws ParseException {
        return new ResponseEntity<>(this.ac1008Service.saveAcVoucherdtl(acVoucherdtl), HttpStatus.CREATED);
    }

    @PostMapping("/voucherdtl/add-list")
    public ResponseEntity<List<AcVoucherdtl>> saveAcVoucherdtlList(@RequestBody List<AcVoucherdtl> acVoucherdtls) {
        return new ResponseEntity<>(this.ac1008Service.saveAcVoucherdtlList(acVoucherdtls), HttpStatus.CREATED);
    }

    @PutMapping("/voucherdtl/update")
    public ResponseEntity<AcVoucherdtl> updateAcVoucherdtl(@RequestBody AcVoucherdtl acVoucherdtl) throws ResourceNotFoundException, ParseException {
        return new ResponseEntity<>(this.ac1008Service.updateAcVoucherdtl(acVoucherdtl), HttpStatus.ACCEPTED);
    }

    @PutMapping("/voucherdtl/update-list")
    public ResponseEntity<List<AcVoucherdtl>> updateAcVoucherdtlList(@RequestBody List<AcVoucherdtl> acVoucherdtls) throws ResourceNotFoundException, ParseException {
        return new ResponseEntity<>(this.ac1008Service.updateAcVoucherdtlList(acVoucherdtls), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/voucherdtl/delete")
    public ResponseEntity<Map> deleAcVoucherdtl(@RequestParam Long subregionNo) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.ac1008Service.deleteAcVoucherdtl(subregionNo), HttpStatus.OK);
    }

    @DeleteMapping("/voucherdtl/delete-list")
    public ResponseEntity<Map> deleteAcVoucherdtlList(@RequestBody List<AcVoucherdtl> acVoucherdtls) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.ac1008Service.deleteAcVoucherdtlList(acVoucherdtls), HttpStatus.OK);
    }
}
