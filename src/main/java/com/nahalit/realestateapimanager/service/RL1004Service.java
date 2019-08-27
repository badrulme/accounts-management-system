package com.nahalit.realestateapimanager.service;

import com.nahalit.realestateapimanager.model.RlItem;
import com.nahalit.realestateapimanager.repository.RlItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RL1004Service {
    private final RlItemRepository rlItemRepository;

    @Autowired
    public RL1004Service(RlItemRepository rlItemRepository) {
        this.rlItemRepository = rlItemRepository;
    }

    public List<RlItem> getAllItem() {
        return this.rlItemRepository.findAll();
    }

    public RlItem saveRlItem(RlItem rlItem) {
        return this.rlItemRepository.save(rlItem);
    }

}
