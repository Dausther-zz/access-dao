package br.com.bb.persistence.api;

import br.com.bb.persistence.core.Persistent;

import java.io.Serializable;

public interface IPersistenceProvider {
    <E extends Persistent<? extends Serializable>> boolean delete(Class<E> classDomain, E entity);
}
