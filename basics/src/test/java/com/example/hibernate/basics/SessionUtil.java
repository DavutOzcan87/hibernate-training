package com.example.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionUtil
{
    private static SessionUtil sessionUtil = new SessionUtil();

    SessionFactory sessionFactory = null;
    public static SessionUtil getSessionUtil() {
        return sessionUtil;
    }

    private SessionUtil() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    Session getSession()
    {
        return sessionFactory.openSession();
    }


}
