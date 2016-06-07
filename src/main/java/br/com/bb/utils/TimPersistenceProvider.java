package br.com.bb.utils;

import br.com.bb.persistence.api.PersistenceProviderJpa;
import javax.persistence.EntityManager;

public class TimPersistenceProvider extends PersistenceProviderJpa {
    private EntityManager entityManager;

    public TimPersistenceProvider(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
