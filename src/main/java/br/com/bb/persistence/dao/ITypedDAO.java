package br.com.bb.persistence.dao;

import br.com.bb.persistence.core.Persistent;
import java.io.Serializable;

public interface ITypedDAO<KEY extends Serializable, E extends Persistent<KEY>> {
    boolean delete(E entity);
}