package com.nt.source;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.lang.ref.Reference;

public class EditCityController implements ApplicationEventPublisherAware {
    ApplicationEventPublisher publisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher =publisher;
    }
    public void update(String tableName,String cityName){
        //open database connection
        System.out.println("Updated table : "+tableName+" With City : "+cityName);
        //update the table
        RefreshEvent event=new Reference<>(this);
        event.setTableName(tableName);
        publisher.publishEvent(event);


    }
}
