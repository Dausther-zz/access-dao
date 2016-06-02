package br.com.bb.persistence.dao;

import br.com.bb.persistence.api.IPersistenceProvider;
import br.com.bb.persistence.core.Persistent;

import java.io.Serializable;

public class TypedDao<KEY extends Serializable, E extends Persistent<KEY>> implements ITypedDAO<KEY, E> {
    IPersistenceProvider persistenceProvider;
    Class entityClass;
    E entity;

    @Override
    public boolean delete(E entity) {
        return persistenceProvider.delete(entityClass, entity);
    }
}
