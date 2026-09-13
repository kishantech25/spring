package com.annotation.util;

import com.annotation.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory FACTORY = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .buildSessionFactory();

    private HibernateUtil() {
    }

    public static Session getSession() {
        return FACTORY.openSession();
    }

    public static void closeSession(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public static void closeSessionFactory() {
        if (!FACTORY.isClosed()) {
            FACTORY.close();
        }
    }
}
