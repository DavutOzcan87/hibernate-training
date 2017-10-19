package com.example.hibernate.basics;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleEntityTest {



    @Test
    public void shouldSaveEntity()
    {
        try(Session session = SessionUtil.getSessionUtil().getSession())
        {
            Transaction tx = session.beginTransaction();
            SimpleEntity se = new SimpleEntity();
            se.setContent("test");
            session.save(se);
            tx.commit();
            assertEquals(1 , entityCount());
        }

    }

    private int entityCount() {
        try(Session session = SessionUtil.getSessionUtil().getSession())
        {
            Query query =  session.createQuery("from SimpleEntity");
            return query.list() == null ? 0:query.list().size();
        }
    }


}