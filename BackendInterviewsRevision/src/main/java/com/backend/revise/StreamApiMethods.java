package com.backend.revise;

import com.backend.revise.model.Employe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiMethods {

    public static void main(String[] args) {

        List<Employe> employes=new ArrayList<>(List.of(
             new Employe(1,"Kishan",150000.0,"IT"),
             new Employe(2,"Ramya",200000.0,"IT"),
             new Employe(3,"Julan",20000,"HR"),
             new Employe(4,"Nagendra",120000,"HR"),
             new Employe(4,"Rakesh",20000,"BD")
        ));

        //map example
        List<String> names =employes.stream().map(emp->emp.empName()).collect(Collectors.toList());

        System.out.println(names);

        //filter
        List<Employe> list =employes.stream().filter(emp->emp.empName().startsWith("K")).collect(Collectors.toList());

        list.forEach(System.out::println);

        //reduce

        //aggreagate elements Into single result
    }
}
