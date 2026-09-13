package com.nt.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static{
        try{
            sessionFactory=new Configuration().configure("hibernate.cfg.xml")
                                              .buildSessionFactory();

        }catch (Throwable ex){
            System.err.println("SessionFactory creation faild : "+ex);

        }
    }
    public HibernateUtil(){

    }

    public static Session getSession(){
        return sessionFactory.openSession();
    }
    public static void shutDown(){
        sessionFactory.close();
    }

}
