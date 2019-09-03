package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.exception.ResourceNotFoundException;
import com.nahalit.realestateapimanager.model.RlItemInstallment;
import com.nahalit.realestateapimanager.repository.RlItemInstallmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RlItemInstallmentService {
    private RlItemInstallmentRepository rlItemInstallmentRepository;

    public RlItemInstallmentService(RlItemInstallmentRepository rlItemInstallmentRepository) {
        this.rlItemInstallmentRepository = rlItemInstallmentRepository;
    }

    // RL Item Installment Service
    public List<RlItemInstallment> getAllRlItemInstallment() {
        return this.rlItemInstallmentRepository.findAll();
    }

    public RlItemInstallment getRlItemInstallment(Long installmentNo) throws ResourceNotFoundException {
        return this.rlItemInstallmentRepository.findById(installmentNo).orElseThrow(() -> new ResourceNotFoundException("Item Installment not found for this id:" + installmentNo));
    }

    public List<RlItemInstallment> getRlItemInstallmentList(Long itemNo) {
        return this.rlItemInstallmentRepository.findAllByItemNo(itemNo);
    }

    public RlItemInstallment saveRlItemInstallment(RlItemInstallment reRlItemInstallment) {
        return this.rlItemInstallmentRepository.save(reRlItemInstallment);
    }

    public List<RlItemInstallment> saveRlItemInstallmentList(List<RlItemInstallment> rlItemInstallments) {
        return this.rlItemInstallmentRepository.saveAll(rlItemInstallments);
    }

    public RlItemInstallment updateRlItemInstallment(RlItemInstallment RlItemInstallment) throws ResourceNotFoundException {
        this.rlItemInstallmentRepository.findById(RlItemInstallment.getInstallmentNo()).orElseThrow(() -> new ResourceNotFoundException("Item Installment not for this:" + RlItemInstallment.getInstallmentNo()));
        return this.rlItemInstallmentRepository.save(RlItemInstallment);
    }

    public List<RlItemInstallment> updateRlItemInstallmentList(List<RlItemInstallment> rlItemInstallments) throws ResourceNotFoundException {
        List<RlItemInstallment> saveList = new ArrayList<>();
        for (RlItemInstallment rlItemInstallment : rlItemInstallments) {
            this.rlItemInstallmentRepository.findById(rlItemInstallment.getInstallmentNo()).orElseThrow(() -> new ResourceNotFoundException("Item Installment not for this:" + rlItemInstallment.getInstallmentNo()));
            saveList.add(this.rlItemInstallmentRepository.save(rlItemInstallment));
        }
        return saveList;
    }

    public void deleteRlItemInstallment(Long installmentNo) {
        this.rlItemInstallmentRepository.findById(installmentNo).orElseThrow(() -> new RejectedExecutionException("Item Installment not found for this id: " + installmentNo));
        this.rlItemInstallmentRepository.deleteById(installmentNo);
    }

    public void deleteRlItemInstallmentList(List<RlItemInstallment> rlItemInstallments) {
        for (RlItemInstallment rlItemInstallment : rlItemInstallments) {
            this.rlItemInstallmentRepository.findById(rlItemInstallment.getInstallmentNo()).orElseThrow(() -> new RejectedExecutionException("Item Installment not found for this id: " + rlItemInstallment.getInstallmentNo()));
            this.rlItemInstallmentRepository.deleteById(rlItemInstallment.getInstallmentNo());
        }
    }
}
