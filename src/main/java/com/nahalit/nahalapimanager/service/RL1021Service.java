package com.nahalit.nahalapimanager.service;

import com.nahalit.nahalapimanager.dao.RL1021Dao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RL1021Service {

    private final RL1021Dao rl1021Dao;

    public RL1021Service(RL1021Dao rl1021Dao) {
        this.rl1021Dao = rl1021Dao;
    }

    public List getTrnBalanceList() {
        return rl1021Dao.getTrnBalanceList();
    }
}
