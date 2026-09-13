package com.job.singleton;

public class DateUtil {
    private static volatile DateUtil instance;

    private DateUtil(){

    }
    public static DateUtil getInstance(){
        if(instance == null){
            synchronized (DateUtil.class){
                if(instance == null){
                    instance = new DateUtil();
                }
            }
        }
        return instance;
    }

}
