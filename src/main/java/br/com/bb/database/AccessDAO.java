package br.com.bb.database;

public interface AccessDAO {

    Object save(Object object);

    void update(Object object);

    void delete(Object object);

    void list(Object object);
}
