package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.SaGallery;
import com.nahalit.nahalapimanager.repository.SaGalleryRepository;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SA1010Service {
    private final SaGalleryRepository saGalleryRepository;
    private final AuthService authService;

    public SA1010Service(SaGalleryRepository saGalleryRepository, AuthService authService) {
        this.saGalleryRepository = saGalleryRepository;
        this.authService = authService;
    }

    // SaGallery
    public List<SaGallery> getAllSaGallery() {
        return this.saGalleryRepository.findAll();
    }

    public SaGallery getSaGallery(Long galleryNo) throws ResourceNotFoundException {
        return this.saGalleryRepository.findById(galleryNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + galleryNo));
    }

    public SaGallery saveSaGallery(SaGallery saGallery) throws ParseException {
        saGallery.setSsCreatedOn(UtillDate.getDateTime());
        saGallery.setSsModifiedOn(null);
        saGallery.setSsCreator(authService.getEmpNo());
        return this.saGalleryRepository.save(saGallery);
    }


    public SaGallery updateSaGallery(SaGallery saGallery) throws ResourceNotFoundException, ParseException {
        SaGallery oldData = this.saGalleryRepository.findById(saGallery.getGalleryNo()).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this:" + saGallery.getGalleryNo()));
        saGallery.setSsModifiedOn(UtillDate.getDateTime());
        saGallery.setSsCreatedOn(oldData.getSsCreatedOn());
        saGallery.setSsModifier(authService.getEmpNo());
        return this.saGalleryRepository.save(saGallery);
    }

    public Map deleteSaGallery(Long galleryNo) throws ResourceNotFoundException {

        this.saGalleryRepository.findById(galleryNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id: " + galleryNo));

        this.saGalleryRepository.deleteById(galleryNo);
        Map<String, String> deleteMessage = new HashMap<>();
        deleteMessage.put("deleteStatus", "Transaction Deleted Successfully");
        return deleteMessage;
    }
}
