package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlItemInstallment;
import com.nahalit.realestateapimanager.service.RlItemInstallmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/rest/rl/item-installment")
@RestController
public class RlItemInstallmentController {

    private final RlItemInstallmentService rlItemInstallmentService;

    public RlItemInstallmentController(RlItemInstallmentService rlItemInstallmentService) {
        this.rlItemInstallmentService = rlItemInstallmentService;
    }

    @GetMapping("/")
    public ResponseEntity<List<RlItemInstallment>> getAllInstallment() {
        return new ResponseEntity<>(rlItemInstallmentService.getAllRlItemInstallment(), HttpStatus.OK);
    }

    @GetMapping("/get-item-category")
    public ResponseEntity<RlItemInstallment> getItemInstallment(@Valid @RequestParam("installmentNo") Long installmentNo) throws ResourceNotFoundException {
        return new ResponseEntity<>(rlItemInstallmentService.getRlItemInstallment(installmentNo), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<RlItemInstallment> saveItemInstallment(RlItemInstallment reItemInstallment) {
        return new ResponseEntity<>(rlItemInstallmentService.saveRlItemInstallment(reItemInstallment), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<RlItemInstallment> updateItemInstallment(RlItemInstallment reItemInstallment) throws ResourceNotFoundException {
        return new ResponseEntity<>(rlItemInstallmentService.updateRlItemInstallment(reItemInstallment), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteInstallment(@RequestParam Long installmentNo) {
        this.rlItemInstallmentService.deleteRlItemInstallment(installmentNo);
        return new ResponseEntity<>("Item Installment Deleted Successfully.", HttpStatus.OK);
    }
}
