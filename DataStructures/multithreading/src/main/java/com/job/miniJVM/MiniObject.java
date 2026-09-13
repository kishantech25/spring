package com.job.miniJVM;

import java.util.ArrayList;
import java.util.List;

public class MiniObject {
    private final int id;
    private final String type;
    private boolean marked;

    private final List<MiniObject> refrences =new ArrayList<>();

    public MiniObject(int id, String type) {
        this.id = id;
        this.type = type;
    }
    public void addRefrence(MiniObject object) {
        refrences.add(object);
    }
    public List<MiniObject> getRefrences() {
        return refrences;
    }
    public boolean isMarked() {
        return marked;
    }
    public void mark(){
        marked =true;
    }
    public void unmark(){
        marked =false;
    }
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Object-" + id + "(" + type + ")";
    }
}
