package com.annotation.util;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sessionFactory;
    private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    static {
        //create SessionFactory object
        sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        System.out.println("SessionFactory object created");
    }
    public static Session getSession(){
        Session session=null;
        if(threadLocal.get()==null){
            session=sessionFactory.openSession();
            threadLocal.set(session);
            return session;
        }else{
            session=threadLocal.get();
        }
        return session;
    }//getSession
    //closeSesson
    public static void closeSession(){
        Session session=null;
        if(threadLocal.get()!=null){
            session=threadLocal.get();
            session.close();
            threadLocal.remove();
        }
    }

    public static void closeSessionFactory(){
        if(sessionFactory!=null){
            sessionFactory.close();
            System.out.println("SessionFactory object closed");
        }
    }
}
