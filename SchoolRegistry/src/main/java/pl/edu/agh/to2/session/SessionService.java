package pl.edu.agh.to2.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SessionService {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    private static Session session;

    public static void openSession() {
        session = sessionFactory.openSession();
    }

    public static Session getSession() {
        if(!session.isOpen()) openSession();
        return session;
    }

    public static void closeSession() {
        session.close();
    }


    private static final EntityManagerFactory emf = Persistence.
            createEntityManagerFactory("dbConfig");


    private static EntityManager em = emf.createEntityManager();

    public static EntityManager getEntityManager(){
        return em;
    }

    public static EntityTransaction getEntityTransaction() {
        return em.getTransaction();
    }

    public static void closeEntityTransaction(){
        em.close();
    }

}
