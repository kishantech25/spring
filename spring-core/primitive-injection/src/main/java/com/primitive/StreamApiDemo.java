package com.primitive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamApiDemo {


    public static void m(List<Chip> chips){

//        List<Chip> filteredChip =new ArrayList<>();
//        //Without Stream Api
//
//        for(Chip chip:chips){
//            if(chip.getType().equals("Kishan Kumar")){
//               filteredChip.add(chip);
//            }
//        }
//        for(Chip chip : filteredChip){
//            System.out.println(chip.getId());
//        }
        //With Stream APi
        chips.stream().filter(chip->chip.getType().equals("Pallavi Kumari")).sorted().map(c->c.getId()).forEach(System.out::println);
    }

}
