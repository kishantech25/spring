package com.example;

public class Test {

    public static void main(String[] args) {

        CustomeArrayList arrayList = new CustomeArrayList();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);

        //print Element


        for(int i=0;i<arrayList.size();i++){
                  arrayList.remove(i);
        }
        for(int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }








    }
}
