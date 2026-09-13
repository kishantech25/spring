package com.i18n.multithread;

public class CalculateTable {

    private static CalculateTable instances;
    private int tableNo;
    private ThreadLocal<Integer> tl;

    public static CalculateTable getInstance(){
        if(instances ==null){
            instances=new CalculateTable();
        }
        return instances;
    }
    private CalculateTable(){
        tl=new ThreadLocal<Integer>();
    }
    public void setTableNo(int tableNo)
    {
        tl.set(tableNo);
        this.tableNo=tableNo;
    }
    public void show(){
        for(int i=1;i<10;i++){
            try{
                Thread.sleep(300);
                System.out.println(Thread.currentThread().getName()+":"+(tl.get()+i));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
