package br.com.bb.persistence.dao;

import br.com.bb.persistence.core.Persistent;
import java.io.Serializable;

public abstract class TypedDao<KEY extends Serializable, E extends Persistent<KEY>> implements ITypedDAO<KEY, E> {

    @Override
    public abstract boolean delete(E entity);
}
