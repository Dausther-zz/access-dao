package br.com.bb.dao;

import br.com.bb.entities.User;

import java.util.List;

public interface UserDAO {

    Boolean persist(org.hsqldb.rights.User user);

    void delete(Long userId);

    void update(User user);

    User find(Long userId);

    List<User> find();

}
