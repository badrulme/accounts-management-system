package com.nahalit.nahalapimanager.service;


import org.springframework.stereotype.Service;


@Service
public class SA1011Service {
//    private final SaMessageRepository saMessageRepository;
//    private final AuthService authService;
//
//    public SA1011Service(SaMessageRepository saMessageRepository, AuthService authService) {
//        this.saMessageRepository = saMessageRepository;
//        this.authService = authService;
//    }
//
//    // SaMessage
//    public List<SaMessage> getAllSaGallery() {
//        return this.saMessageRepository.findAll();
//    }
//
//    public SaMessage getSaGallery(Long galleryNo) throws ResourceNotFoundException {
//        return this.saMessageRepository.findById(galleryNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + galleryNo));
//    }
//
//    public SaMessage saveSaGallery(SaMessage saGallery) throws ParseException {
//        saGallery.setSsCreatedOn(UtillDate.getDateTime());
//        saGallery.setSsModifiedOn(null);
//        saGallery.setSsCreator(authService.getEmpNo());
//        return this.saMessageRepository.save(saGallery);
//    }
//
//
//    public SaMessage updateSaGallery(SaMessage saGallery) throws ResourceNotFoundException, ParseException {
//        SaMessage oldData = this.saMessageRepository.findById(saGallery.getGalleryNo()).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this:" + saGallery.getGalleryNo()));
//        saGallery.setSsModifiedOn(UtillDate.getDateTime());
//        saGallery.setSsCreatedOn(oldData.getSsCreatedOn());
//        saGallery.setSsModifier(authService.getEmpNo());
//        return this.saMessageRepository.save(saGallery);
//    }
//
//    public Map deleteSaGallery(Long galleryNo) throws ResourceNotFoundException {
//
//        this.saMessageRepository.findById(galleryNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id: " + galleryNo));
//
//        this.saMessageRepository.deleteById(galleryNo);
//        Map<String, String> deleteMessage = new HashMap<>();
//        deleteMessage.put("deleteStatus", "Transaction Deleted Successfully");
//        return deleteMessage;
//    }
}
