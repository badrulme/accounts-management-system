package com.nahalit.realestateapimanager.controller;

import com.nahalit.realestateapimanager.service.SA1002Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/rest/dashboard")
@RestController
public class SA1002Controller {
    private final SA1002Service sa1002Service;

    public SA1002Controller(SA1002Service sa1002Service) {
        this.sa1002Service = sa1002Service;
    }

    @GetMapping("/user-menu")
    public List getUserMenu(@Valid @RequestParam(value = "menuId", required = false) String menuId, @Valid @RequestParam(value = "submenuType", required = false) String submenuType, @Valid @RequestParam String empNo) {
        return sa1002Service.getUserMenu(menuId, submenuType, empNo);
    }
}
