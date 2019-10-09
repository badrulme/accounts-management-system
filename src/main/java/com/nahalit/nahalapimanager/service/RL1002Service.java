package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.dao.RL1002Dao;
import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlCustomer;
import com.nahalit.nahalapimanager.model.SaLookupdtl;
import com.nahalit.nahalapimanager.repository.RlCustomerRepository;
import com.nahalit.nahalapimanager.repository.SaLookupdtlRepository;
import com.nahalit.nahalapimanager.storage.StorageService;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class RL1002Service {

    private RlCustomerRepository customerRepository;
    private StorageService storageService;
    private RL1002Dao rl1002Dao;
    private SaLookupdtlRepository saLookupdtlRepository;

    public RL1002Service(RlCustomerRepository customerRepository, StorageService storageService, RL1002Dao rl1002Dao, SaLookupdtlRepository saLookupdtlRepository) {
        this.customerRepository = customerRepository;
        this.storageService = storageService;
        this.rl1002Dao = rl1002Dao;
        this.saLookupdtlRepository = saLookupdtlRepository;
    }

    public List<RlCustomer> getAllCustomer() {
        return this.customerRepository.findAll(Sort.by("customerNo").ascending());
    }

    public RlCustomer getCustomer(Long customerNo) throws ResourceNotFoundException {
        return this.customerRepository.findById(customerNo).orElseThrow(() -> new ResourceNotFoundException("RlCustomer not found for this id: " + customerNo));
    }

    public RlCustomer saveCustomer(RlCustomer customer, MultipartFile customerPhoto) throws ParseException {
        if (customerPhoto != null) {
            String nowTime = UtillDate.getNowTimeNameForImage();
            String filename = StringUtils.cleanPath(customerPhoto.getOriginalFilename()).replaceAll("(?i)(.+?)(\\.\\w+$)", nowTime + "$2");
            storageService.store(customerPhoto, filename);
            customer.setCustomerPictureName(filename);
        }
        customer.setSsCreatedOn(UtillDate.getDateTime());
        customer.setSsModifiedOn(null);

        return this.customerRepository.save(customer);
    }

    public RlCustomer updateCustomer(RlCustomer customer, MultipartFile customerPhoto) throws ResourceNotFoundException, ParseException {
        RlCustomer oldData = this.customerRepository.findById(customer.getCustomerNo()).orElseThrow(() -> new ResourceNotFoundException("RlCustomer not found for this id: " + customer.getCustomerNo()));
        if (customerPhoto != null) {
            if (customer.getCustomerPictureName().length() > 0) {
                String filename = StringUtils.cleanPath(customer.getCustomerPictureName());
                storageService.store(customerPhoto, filename);
            } else {
                String nowTime = UtillDate.getNowTimeNameForImage();
                String filename = StringUtils.cleanPath(customerPhoto.getOriginalFilename()).replaceAll("(?i)(.+?)(\\.\\w+$)", nowTime + "$2");
                storageService.store(customerPhoto, filename);
                customer.setCustomerPictureName(filename);
            }
        }
        customer.setSsCreatedOn(oldData.getSsCreatedOn());
        customer.setSsModifiedOn(UtillDate.getDateTime());

        return this.customerRepository.save(customer);
    }

    public void deleteCustomer(Long customerNo) throws ResourceNotFoundException, IOException {
        RlCustomer rlCustomer = this.customerRepository.findById(customerNo).orElseThrow(() -> new ResourceNotFoundException("RlCustomer not found for this id: " + customerNo));
        storageService.deleteFile(rlCustomer.getCustomerPictureName());
        this.customerRepository.deleteById(customerNo);
    }

    public Map<String, Object> customerLogin(String customerUsername, String password) {
        return rl1002Dao.isCustomerLogin(customerUsername, password);
    }

    public String forgotPasswordByMail(String email) {
        return rl1002Dao.forgotPasswordByMail(email);
    }
}
