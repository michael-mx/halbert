package com.halbert.service;


import com.halbert.dao.TreatMapper;
import com.halbert.model.TreatLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatService {
    @Autowired
    TreatMapper treatMapper;
    public void create(TreatLog log){
         treatMapper.insert(log);
    }

    public void update(TreatLog log){
         treatMapper.update(log);
    }

    public List<TreatLog> query(long planId){
        return treatMapper.list(planId);
    }
}
