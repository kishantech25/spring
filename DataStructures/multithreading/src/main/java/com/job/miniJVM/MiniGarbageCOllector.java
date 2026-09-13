package com.job.miniJVM;

import java.util.Iterator;

public class MiniGarbageCOllector {
    private final MiniHeap heap;

    private final GCRoots roots;

    public MiniGarbageCOllector(MiniHeap heap,GCRoots roots) {
        this.heap = heap;
        this.roots = roots;
    }

    public void collect(){
        System.out.println("\n ===============GC START ==================");

        mark();
        sweep();
        System.out.println("========== GC End==========\n");
    }
    public void mark(){
        System.out.print("\n[MARK PAHSE]");
        for(MiniObject root:roots.getRoots()){
            markReachable(root);
        }
    }
    private void markReachable(MiniObject object) {

        if (object == null) {
            return;
        }

        if (object.isMarked()) {
            return;
        }

        object.mark();

        System.out.println(
                "MARKED: " + object
        );

        for (MiniObject reference :
                object.getRefrences()) {

            markReachable(reference);
        }
    }

    private void sweep() {

        System.out.println("\n[SWEEP PHASE]");

        Iterator<MiniObject> iterator =
                heap.getObjects().iterator();

        while (iterator.hasNext()) {

            MiniObject object = iterator.next();

            if (!object.isMarked()) {

                System.out.println(
                        "COLLECTED: " + object
                );

                iterator.remove();

            } else {

                object.unmark();
            }
        }
    }
}
