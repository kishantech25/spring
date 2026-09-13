package com.kk.SpringDemoApplication.service;

import com.kk.SpringDemoApplication.model.Laptop;
import com.kk.SpringDemoApplication.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository  laptopRepository;

    public void addLaptop(Laptop lap){
        laptopRepository.save(lap);
    }
    public boolean isGoodForProg(Laptop lap){
        return true;
    }

}
