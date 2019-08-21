package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlItemInstallment;
import com.nahalit.realestateapimanager.repository.RlItemInstallmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RlItemInstallmentService {
    private final RlItemInstallmentRepository rlItemInstallmentRepository;

    public RlItemInstallmentService(RlItemInstallmentRepository rlItemInstallmentRepository) {
        this.rlItemInstallmentRepository = rlItemInstallmentRepository;
    }

    public List<RlItemInstallment> getAllRlItemInstallment() {
        return this.rlItemInstallmentRepository.findAll();
    }

    public RlItemInstallment getRlItemInstallment(Long installmentNo) throws ResourceNotFoundException {
        return this.rlItemInstallmentRepository.findById(installmentNo).orElseThrow(() -> new ResourceNotFoundException("Item Installment not found for this id:" + installmentNo));
    }

    public RlItemInstallment saveRlItemInstallment(RlItemInstallment reRlItemInstallment) {
        return this.rlItemInstallmentRepository.save(reRlItemInstallment);
    }

    public RlItemInstallment updateRlItemInstallment(RlItemInstallment reRlItemInstallment) throws ResourceNotFoundException {
        this.rlItemInstallmentRepository.findById(reRlItemInstallment.getInstallmentNo()).orElseThrow(() -> new ResourceNotFoundException("Item Installment not for this:" + reRlItemInstallment.getInstallmentNo()));
        return this.rlItemInstallmentRepository.save(reRlItemInstallment);
    }


    public void deleteRlItemInstallment(Long installmentNo) {
        this.rlItemInstallmentRepository.findById(installmentNo).orElseThrow(() -> new RejectedExecutionException("Item Installment not found for this id: " + installmentNo));
        this.rlItemInstallmentRepository.deleteById(installmentNo);
    }

}
