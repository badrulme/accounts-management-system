package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.AcVoucher;
import com.nahalit.nahalapimanager.model.AcVoucherdtl;
import com.nahalit.nahalapimanager.repository.AcVoucherRepository;
import com.nahalit.nahalapimanager.repository.AcVoucherdtlRepository;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

@Service
public class AC1008Service {
    private final AcVoucherRepository acVoucherRepository;
    private final AcVoucherdtlRepository acVoucherdtlRepository;
    private final AuthService authService;

    public AC1008Service(AcVoucherRepository acVoucherRepository, AcVoucherdtlRepository acVoucherdtlRepository, AuthService authService) {
        this.acVoucherRepository = acVoucherRepository;
        this.acVoucherdtlRepository = acVoucherdtlRepository;
        this.authService = authService;
    }


    // Ac Voucher
    public List<AcVoucher> getAllAcVoucher() {
        return this.acVoucherRepository.findAll();
    }

    public AcVoucher getAcVoucher(Long vNo) throws ResourceNotFoundException {
        return this.acVoucherRepository.findById(vNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + vNo));
    }

    public AcVoucher saveAcVoucher(AcVoucher acVoucher) throws ParseException {
        acVoucher.setSsCreatedOn(UtillDate.getDateTime());
        acVoucher.setSsModifiedOn(null);
        acVoucher.setSsCreator(authService.getUserNo());
        acVoucher.setCompanyNo(authService.getCompanyNo());
        return this.acVoucherRepository.save(acVoucher);
    }

    public List<AcVoucher> saveAcVoucherList(List<AcVoucher> acVoucherList) {
        return this.acVoucherRepository.saveAll(acVoucherList);
    }

    public AcVoucher updateAcVoucher(AcVoucher acVoucher) throws ResourceNotFoundException, ParseException {
        AcVoucher oldData = this.acVoucherRepository.findById(acVoucher.getVNo()).orElseThrow(() -> new ResourceNotFoundException("Transaction not for this:" + acVoucher.getVNo()));
        acVoucher.setSsModifiedOn(UtillDate.getDateTime());
        acVoucher.setSsCreatedOn(oldData.getSsCreatedOn());
        acVoucher.setSsModifier(authService.getUserNo());
        acVoucher.setSsCreator(oldData.getSsCreator());
        acVoucher.setCompanyNo(oldData.getCompanyNo());
        return this.acVoucherRepository.save(acVoucher);
    }

    public Map deleteAcVoucher(Long vNo) {

        this.acVoucherRepository.findById(vNo).orElseThrow(() -> new RejectedExecutionException("Transaction not found for this id: " + vNo));

        this.acVoucherRepository.deleteById(vNo);
        Map<String, String> deleteMessage = new HashMap<>();
        deleteMessage.put("deleteStatus", "Transaction Deleted Successfully");
        return deleteMessage;
    }


    // AC Voucherdtl
    public List<AcVoucherdtl> getAllAcVoucherdtl() {
        return acVoucherdtlRepository.findAll();
    }

    public List<AcVoucherdtl> getAllAcVoucherdtlList(Long vNo) {
        return acVoucherdtlRepository.findAllByVNo(vNo);
    }

    public AcVoucherdtl getAcVoucherdtl(Long vdtlNo) throws ResourceNotFoundException {
        return acVoucherdtlRepository.findById(vdtlNo).orElseThrow(() -> new ResourceNotFoundException("Voucherdtl Not found for this id: " + vdtlNo));
    }

    public AcVoucherdtl saveAcVoucherdtl(AcVoucherdtl acVoucherdtl) throws ParseException {
        acVoucherdtl.setSsCreatedOn(UtillDate.getDateTime());
        acVoucherdtl.setSsModifiedOn(null);
        acVoucherdtl.setCompanyNo(authService.getCompanyNo());
        acVoucherdtl.setSsCreator(authService.getUserNo());
        return acVoucherdtlRepository.save(acVoucherdtl);
    }

    public List<AcVoucherdtl> saveAcVoucherdtlList(List<AcVoucherdtl> acVoucherdtls) {
        List<AcVoucherdtl> acVoucherdtlList = new ArrayList<>();
        acVoucherdtls.forEach(acVoucherdtl -> {
            try {
                acVoucherdtl.setSsCreatedOn(UtillDate.getDateTime());
                acVoucherdtl.setSsModifiedOn(null);
                acVoucherdtl.setCompanyNo(authService.getCompanyNo());
                acVoucherdtl.setSsCreator(authService.getUserNo());
                acVoucherdtlList.add(this.acVoucherdtlRepository.save(acVoucherdtl));
            } catch (ParseException e) {
            }
        });
        return acVoucherdtlList;
    }

    public AcVoucherdtl updateAcVoucherdtl(AcVoucherdtl acVoucherdtl) throws ResourceNotFoundException, ParseException {
        AcVoucherdtl oldData = this.acVoucherdtlRepository.findById(acVoucherdtl.getVdtlNo()).orElseThrow(() -> new ResourceNotFoundException("AcVoucherdtl not found for this id: " + acVoucherdtl.getVdtlNo()));
        acVoucherdtl.setSsCreatedOn(oldData.getSsCreatedOn());
        acVoucherdtl.setSsModifiedOn(UtillDate.getDateTime());
        acVoucherdtl.setCompanyNo(oldData.getCompanyNo());
        acVoucherdtl.setSsModifier(authService.getUserNo());
        return this.acVoucherdtlRepository.save(acVoucherdtl);
    }

    public List<AcVoucherdtl> updateAcVoucherdtlList(List<AcVoucherdtl> acVoucherdtls) throws ResourceNotFoundException, ParseException {
        List<AcVoucherdtl> saveData = new ArrayList<>();
        for (AcVoucherdtl acVoucherdtl : acVoucherdtls) {
            AcVoucherdtl oldData = this.acVoucherdtlRepository.findById(acVoucherdtl.getVNo()).orElseThrow(() -> new ResourceNotFoundException("AcVoucherdtl not found for this id: " + acVoucherdtl.getVdtlNo()));
            acVoucherdtl.setSsCreatedOn(oldData.getSsCreatedOn());
            acVoucherdtl.setSsModifiedOn(UtillDate.getDateTime());
            acVoucherdtl.setCompanyNo(oldData.getCompanyNo());
            acVoucherdtl.setSsModifier(authService.getUserNo());
            saveData.add(acVoucherdtlRepository.save(acVoucherdtl));
        }
        return saveData;
    }

    public Map deleteAcVoucherdtl(Long vdtlNo) throws ResourceNotFoundException {
        this.acVoucherdtlRepository.findById(vdtlNo).orElseThrow(() -> new ResourceNotFoundException("AcVoucherdtl not found for this id: " + vdtlNo));
        this.acVoucherdtlRepository.deleteById(vdtlNo);
        Map<String, String> deleteMessage = new HashMap<>();
        deleteMessage.put("deleteStatus", "Deleted Successfully");
        return deleteMessage;
    }

    public Map deleteAcVoucherdtlList(List<AcVoucherdtl> acVoucherdtls) throws ResourceNotFoundException {
        for (AcVoucherdtl acVoucherdtl : acVoucherdtls) {
            this.acVoucherdtlRepository.findById(acVoucherdtl.getVdtlNo()).orElseThrow(() -> new ResourceNotFoundException("AcVoucherdtl not found for this id: " + acVoucherdtl.getVdtlNo()));
            this.acVoucherdtlRepository.deleteById(acVoucherdtl.getVdtlNo());
        }
        Map<String, String> deleteMessage = new HashMap<>();
        deleteMessage.put("deleteStatus", "Deleted Successfully");
        return deleteMessage;
    }
}