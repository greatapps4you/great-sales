package br.com.greatsoft.greaterp.model.util;

import org.hibernate.SessionFactory;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    public HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    static {
        try {
            sessionFactory = DBConnector.buildSessionFactory();
        } catch (Exception var1) {
            System.err.println("Initial SessionFactory creation failed." + var1);
            throw new ExceptionInInitializerError(var1);
        }
    }
}
