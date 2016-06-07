package br.com.bb.persistence.util;

import br.com.bb.entities.User;
import br.com.bb.persistence.api.IPersistenceProvider;
import br.com.bb.persistence.dao.TypedDao;
import br.com.bb.utils.TimPersistenceProvider;

public class TestDAO extends TypedDao<Long, User> {

    private TimPersistenceProvider timPersistenceProvider;


    public TestDAO(Class<Long> longClass, Class<User> entityClass, TimPersistenceProvider timPersistenceProvider) {
        super(longClass, entityClass);
        this.timPersistenceProvider = timPersistenceProvider;
    }

    @Override
    protected IPersistenceProvider getPersistenceProvider() {
        return timPersistenceProvider;
    }
}
