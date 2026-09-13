package com.i18n.multithread;

import java.util.Random;

public class MyThread extends Thread{

    private CalculateTable cal;

    public MyThread(){
        cal =CalculateTable.getInstance();
    }

    @Override
    public void run() {
        cal.setTableNo(new Random().nextInt(10));
        cal.show();
    }
}
