package br.com.bb.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerUtil {
    private static final EntityManagerFactory entityManagerFactory;

    /* Bloco inicializado prioritariamente na classe
    Não necessita de uma instância da classe
     */
    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("test");

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
