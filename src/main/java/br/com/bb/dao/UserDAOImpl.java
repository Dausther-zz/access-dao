package br.com.bb.dao;


import br.com.bb.entities.User;

import javax.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;

public class UserDAOImpl implements UserDAO{

    private final EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    @Override
    public Boolean persist(User user) {
        try {
            entityManager.getTransaction().begin();
             entityManager.merge(user);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public void delete(Long userId) {
        try {
            entityManager.getTransaction().begin();
            User user = (User) entityManager.find(User.class, userId);
            entityManager.remove(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(User user) {
        try {
            entityManager.getTransaction().begin();
            user = entityManager.getReference(User.class, user.getUserId());
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public User find(Long userId) {
        User user = null;
        try {
            entityManager.getTransaction().begin();
            @SuppressWarnings("unchecked")
            List<User> users = entityManager.createQuery("SELECT e FROM User e where User.userId = " + userId).getResultList();
            for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
                user = iterator.next();
                System.out.println(user.getUserId()+" "+user.getUserName());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();

        }
        return user;
    }



}
