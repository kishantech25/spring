package com.job.miniJVM;

import java.util.ArrayList;
import java.util.List;

public class MiniHeap {
    private final List<MiniObject> objects =new ArrayList<>();

    private int nextId =1;

    public MiniObject allocate(String type){
        MiniObject object=new MiniObject(nextId++,type);
        objects.add(object);
        System.out.println("Allocate "+type+" "+object);
        return object;
    }
    public void remove(MiniObject object){
        objects.remove(object);
    }

    public List<MiniObject> getObjects() {
        return objects;
    }

    public void printHeap() {
    System.out.println("Heap Objects:");
    for (MiniObject object : objects) {
        System.out.println(object + "->" + object.getRefrences());
    }
  }

}
