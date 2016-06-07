package br.com.bb.persistence.dao;

import br.com.bb.persistence.api.IPersistenceProvider;
import br.com.bb.persistence.core.Persistent;
import java.io.Serializable;

public abstract class TypedDao<KEY extends Serializable, E extends Persistent<KEY>> implements ITypedDAO<KEY, E> {

    protected Class<KEY> keyClass;
    protected Class<E> entityClass;

    public TypedDao(Class<KEY> keyClass, Class<E> entityClass) {
        this.keyClass = keyClass;
        this.entityClass = entityClass;
    }

    protected abstract IPersistenceProvider getPersistenceProvider();

    @Override
    public boolean delete(E entity){
        return getPersistenceProvider().delete(entityClass, entity);
    }
}
