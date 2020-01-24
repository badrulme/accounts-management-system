package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.InItem;
import com.nahalit.nahalapimanager.repository.InItemRepository;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

@Service
public class IN1002Service {
    private final InItemRepository inItemRepository;
    private final AuthService authService;

    public IN1002Service(InItemRepository inItemRepository, AuthService authService) {
        this.inItemRepository = inItemRepository;
        this.authService = authService;
    }


    // In Transaction
    public List<InItem> getAllInItem() {
        return this.inItemRepository.findAll();
    }

    public InItem getInItem(Long itemNo) throws ResourceNotFoundException {
        return this.inItemRepository.findById(itemNo).orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id:" + itemNo));
    }

    public InItem saveInItem(InItem inItem) throws ParseException {
        inItem.setSsCreatedOn(UtillDate.getDateTime());
        inItem.setSsModifiedOn(null);
        inItem.setSsCreator(authService.getUserNo());
        return this.inItemRepository.save(inItem);
    }

    public List<InItem> saveInItemList(List<InItem> inItemList) {
        return this.inItemRepository.saveAll(inItemList);
    }

    public InItem updateInItem(InItem inItem) throws ResourceNotFoundException, ParseException {
        InItem oldData = this.inItemRepository.findById(inItem.getItemNo()).orElseThrow(() -> new ResourceNotFoundException("Transaction not for this:" + inItem.getItemNo()));
        inItem.setSsModifiedOn(UtillDate.getDateTime());
        inItem.setSsCreatedOn(oldData.getSsCreatedOn());
        inItem.setSsModifier(authService.getUserNo());
        inItem.setSsCreator(oldData.getSsCreator());
        return this.inItemRepository.save(inItem);
    }

    public Map deleteInItem(Long itemNo) {

        this.inItemRepository.findById(itemNo).orElseThrow(() -> new RejectedExecutionException("Transaction not found for this id: " + itemNo));

        this.inItemRepository.deleteById(itemNo);
        Map<String, String> deleteMessage = new HashMap<>();
        deleteMessage.put("deleteStatus", "Transaction Deleted Successfully");
        return deleteMessage;
    }

}
