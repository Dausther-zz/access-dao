package br.com.bb.persistence.api;

import br.com.bb.persistence.core.Persistent;

import javax.persistence.EntityManager;
import java.io.Serializable;

public abstract class PersistenceProviderJpa implements IPersistenceProvider {

    protected abstract EntityManager getEntityManager();

    @Override
    public <E extends Persistent<? extends Serializable>> boolean delete(Class<E> entityClass, E entity) {

        boolean hasBeenDeleted = false;

        try {
            E element = getEntityManager().find(entityClass, entity.getId());
            if (element != null) {
                getEntityManager().remove(element);
                hasBeenDeleted = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return hasBeenDeleted;
    }

}
