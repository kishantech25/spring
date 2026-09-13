package com.job;

import com.job.miniJVM.GCRoots;
import com.job.miniJVM.MiniGarbageCOllector;
import com.job.miniJVM.MiniHeap;
import com.job.miniJVM.MiniObject;

public class TestMiniGC {
    public static void main(String[] args) {

        MiniHeap heap = new MiniHeap();
        GCRoots roots =new GCRoots();

        MiniGarbageCOllector gc =new MiniGarbageCOllector(heap,roots);

        //Object A
        MiniObject account =heap.allocate("Account");

        //Object B
        MiniObject deposit =heap.allocate("Transaction");

        //Object C
        MiniObject customer =heap.allocate("Customer");
        //Object D
        MiniObject transaction =heap.allocate("Address");

        //only Account is GC Root

        roots.addRoot(account);
        heap.printHeap();
        gc.collect();
        heap.printHeap();



    }
}
