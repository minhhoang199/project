package com.tm.j10.service;

import com.tm.j10.domain.Store;
import com.tm.j10.repository.StoreRepository;
import io.undertow.servlet.core.ApplicationListeners;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    private StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository){
        this.storeRepository=storeRepository;
    }
    public List<Store> getAllStore(){
        return this.storeRepository.findAll();
    }

}
