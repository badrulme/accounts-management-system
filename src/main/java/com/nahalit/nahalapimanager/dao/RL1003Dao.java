package com.nahalit.nahalapimanager.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RL1003Dao {
   List getAllProjectRef(Long projectNo);
}
