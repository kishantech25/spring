package com.ds.conn;

import java.sql.Connection;

public class DBCOnnection {

    public static DBCOnnection instance;

    private static Connection connection;

    private DBCOnnection(){

    }

    public static DBCOnnection getInstance(){
         if(instance == null){
             synchronized (DBCOnnection.class){
                  if(instance==null){
                      instance =new DBCOnnection();
                  }
             }
         }
         return instance;
    }

    public static void closeCOnnection(){
        if(instance !=null){
              try {
                  connection.close();
              }
              catch (Exception e){
                  e.printStackTrace();
              }
        }

    }
}
