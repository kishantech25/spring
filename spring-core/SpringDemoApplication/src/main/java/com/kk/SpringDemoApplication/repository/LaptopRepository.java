package com.kk.SpringDemoApplication.repository;

import com.kk.SpringDemoApplication.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {

    public void save(Laptop lap){
        System.out.println( lap.getClass().getName()+" Saved in database ....");
    }


}
