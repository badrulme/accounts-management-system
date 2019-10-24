package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.dao.RL1005Dao;
import com.nahalit.nahalapimanager.dao.RLItemDao;
import com.nahalit.nahalapimanager.storage.StorageService;
import com.nahalit.nahalapimanager.utillibrary.UtillDate;
import com.nahalit.nahalapimanager.exception.ResourceNotFoundException;
import com.nahalit.nahalapimanager.model.RlItem;
import com.nahalit.nahalapimanager.repository.RlItemRepository;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

@Service
public class RL1005Service {
    private final RlItemRepository rlItemRepository;
    private final RL1005Dao rl1005Dao;
    private final StorageService storageService;
    private final RLItemDao rlItemDao;

    public RL1005Service(RlItemRepository rlItemRepository, RL1005Dao rl1005Dao, StorageService storageService, RLItemDao rlItemDao) {
        this.rlItemRepository = rlItemRepository;
        this.rl1005Dao = rl1005Dao;
        this.storageService = storageService;
        this.rlItemDao = rlItemDao;
    }

    // RL Item For Apartment
    public List getAllApItem(String itemNo) throws ResourceNotFoundException {
        if (itemNo != null) {
            this.rlItemRepository.findById(Long.parseLong(itemNo)).orElseThrow(() -> new ResourceNotFoundException("Apartment item not found for this id:" + itemNo));
        }
        return this.rlItemDao.getAllItemRef(itemNo,"2",null);
    }


    public Object getApItem(String itemNo) {
        return this.rlItemDao.getItemDetails(itemNo);

    }

    public RlItem saveApRlItem(RlItem rlItem) throws ParseException {
        rlItem.setSsCreatedOn(UtillDate.getDateTime());
        rlItem.setSsModifiedOn(null);
        rlItem.setItemTypeNo(2L);
        rlItem.setItemId(rlItemDao.getItemId("2"));
        return this.rlItemRepository.save(rlItem);
    }

    public RlItem updateApRlItem(RlItem rlItem) throws ResourceNotFoundException, ParseException, IOException {
        RlItem oldData = this.rlItemRepository.findById(rlItem.getItemNo()).orElseThrow(() -> new ResourceNotFoundException("Apartment Item not found for this id:" + rlItem.getItemNo()));
        if(oldData.getItemBrandPhoto()!=null && rlItem.getItemBrandPhoto()!=null && oldData.getItemBrandPhoto()!= rlItem.getItemBrandPhoto()){
            this.storageService.deleteFile(oldData.getItemBrandPhoto());
        }
        rlItem.setSsCreatedOn(oldData.getSsCreatedOn());
        rlItem.setSsModifiedOn(UtillDate.getDateTime());
        return this.rlItemRepository.save(rlItem);
    }

    public Map deleteApRlItem(Long itemNo) throws IOException {
        RlItem rlItem = this.rlItemRepository.findById(itemNo).orElseThrow(() -> new RejectedExecutionException("Apartment Item not found for this id: " + itemNo));
        if(rlItem.getItemBrandPhoto()!=null){
            this.storageService.deleteFile(rlItem.getItemBrandPhoto());
        }
        this.rlItemRepository.deleteById(itemNo);
        Map<String, String> deleteMessage = new HashMap<>();
        deleteMessage.put("deleteStatus", "Deleted Successfully");
        return deleteMessage;
    }

    public List getFeatureProperty(Long itemNo) throws ResourceNotFoundException {
        if (itemNo != null) {
            this.rlItemRepository.findById(itemNo).orElseThrow(() -> new ResourceNotFoundException("Apartment item not found for this id:" + itemNo));

        }
        return this.rlItemDao.getFeatureProperty(itemNo);
    }
}

