package com.nt.model;

import com.nt.cache.Cache;

import java.util.Properties;

public class GetLoanDetails {
    private Cache cache;

 public void setCache(Cache cache){
     this.cache=cache;
 }
 public void getLoanDetails(int principal,int tenure,String type,String city){
     Properties props=null;
     if(cache!=null){
         if(!cache.containsKey("cities")){
             try{
                 throw new Exception("Cities not found");
             }catch (Exception e){
                 e.printStackTrace();
             }
         }else{
             props = (Properties) cache.get("cities");
         }
         if(props!=null){
             if(props.containsKey(city)){
                 double interestRate=Double.parseDouble(props.getProperty(city));
                 double totalAmt=(principal *interestRate/100)* tenure;
                 System.out.println("Interest Rate: "+interestRate+" and Total Amount in "+tenure+" months is: "+totalAmt);
             }else{
                 try{
                     throw new Exception("city Not found");
                 }catch (Exception e){
                     e.printStackTrace();
                 }
             }
         }
     }
 }

}
