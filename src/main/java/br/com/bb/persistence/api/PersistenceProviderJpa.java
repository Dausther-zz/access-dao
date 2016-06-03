package br.com.bb.persistence.api;

import br.com.bb.persistence.core.Persistent;
import br.com.bb.utils.EntityManagerUtil;
import javax.persistence.EntityManager;
import java.io.Serializable;

public class PersistenceProviderJpa implements IPersistenceProvider {

    protected EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public <E extends Persistent<? extends Serializable>> boolean delete(Class<E> entityClass, E entity) {

        boolean hasBeenDeleted = false;

        try {
            entityManager.getTransaction().begin();
            E element = entityManager.find(entityClass, entity);
            if(element != null) {
                entityManager.remove(element);
                hasBeenDeleted = true;
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }

        return hasBeenDeleted;
    }

}
