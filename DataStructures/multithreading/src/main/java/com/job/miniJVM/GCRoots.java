package com.job.miniJVM;

import java.util.HashSet;
import java.util.Set;

public class GCRoots {

    private final Set<MiniObject> roots =new HashSet<MiniObject>();

    public void addRoot(MiniObject object){
        roots.add(object);

        System.out.println("GC Root ADDED: "+object);
    }

    public void removeRoot(MiniObject object){
        roots.remove(object);
    }
    public Set<MiniObject> getRoots(){
        return roots;
    }


}
