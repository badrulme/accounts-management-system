package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.model.SaCompanySlider;
import com.nahalit.nahalapimanager.repository.SaCompanySliderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SA1001Service {
    private final SaCompanySliderRepository saCompanySliderRepository;

    public SA1001Service(SaCompanySliderRepository saCompanySliderRepository) {
        this.saCompanySliderRepository = saCompanySliderRepository;
    }

    public List<SaCompanySlider> getSlider(Long companyNo) {
        return this.saCompanySliderRepository.getCompanySliderByCompanyNo(companyNo);
    }
}
