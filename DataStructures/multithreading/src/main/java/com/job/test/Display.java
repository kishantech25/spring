package com.job.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Display {

    ReentrantLock l =new ReentrantLock();
    public void wishToNonRepaetedCharacter(String name){
        l.lock();
        for(int i=0;i<10;i++){
            System.out.println("Good Morning ");
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Write a logic to find non-repeated characters in the name
            System.out.println(nonRepeatedCharacter(name));
        }
        l.unlock();
    }

    public String nonRepeatedCharacter(String input){

        Character ch =input.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), HashMap::new,Collectors.counting()))
                                   .entrySet().stream().filter(entry->entry.getValue() ==1).map(Map.Entry::getKey).findFirst().orElse(null);

        return String.valueOf(ch);
    }

}
