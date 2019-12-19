package com.nahalit.nahalapimanager.service;


import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.SaMessage;
import com.nahalit.nahalapimanager.repository.SaMessageRepository;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SA1011Service {
    private final SaMessageRepository saMessageRepository;
    private final AuthService authService;

    public SA1011Service(SaMessageRepository saMessageRepository, AuthService authService) {
        this.saMessageRepository = saMessageRepository;
        this.authService = authService;
    }

    // SaMessage
    public List<SaMessage> getAllSaMessage() {
        return this.saMessageRepository.findAll();
    }

    public SaMessage getSaMessage(Long messageNo) throws ResourceNotFoundException {
        return this.saMessageRepository.findById(messageNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + messageNo));
    }

    public SaMessage saveSaMessage(SaMessage saMessage) throws ParseException {
        saMessage.setSsCreatedOn(UtillDate.getDateTime());
        saMessage.setSsModifiedOn(null);
        saMessage.setSsCreator(authService.getEmpNo());
        return this.saMessageRepository.save(saMessage);
    }


    public SaMessage updateSaMessage(SaMessage saMessage) throws ResourceNotFoundException, ParseException {
        SaMessage oldData = this.saMessageRepository.findById(saMessage.getMessageNo()).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this:" + saMessage.getMessageNo()));
        saMessage.setSsModifiedOn(UtillDate.getDateTime());
        saMessage.setSsCreatedOn(oldData.getSsCreatedOn());
        saMessage.setSsModifier(authService.getEmpNo());
        return this.saMessageRepository.save(saMessage);
    }

    public Map deleteSaMessage(Long messageNo) throws ResourceNotFoundException {

        this.saMessageRepository.findById(messageNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id: " + messageNo));

        this.saMessageRepository.deleteById(messageNo);
        Map<String, String> deleteMessage = new HashMap<>();
        deleteMessage.put("deleteStatus", "Transaction Deleted Successfully");
        return deleteMessage;
    }
}
