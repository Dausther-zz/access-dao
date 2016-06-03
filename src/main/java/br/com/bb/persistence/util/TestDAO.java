package br.com.bb.persistence.util;

import br.com.bb.entities.User;
import br.com.bb.persistence.api.IPersistenceProvider;
import br.com.bb.persistence.api.PersistenceProviderJpa;
import br.com.bb.persistence.dao.TypedDao;

public class TestDAO extends TypedDao<Long, User> {

    IPersistenceProvider persistenceProvider = new PersistenceProviderJpa();

    @Override
    public boolean delete(User entity) {
        return persistenceProvider.delete(User.class, entity);
    }
}
