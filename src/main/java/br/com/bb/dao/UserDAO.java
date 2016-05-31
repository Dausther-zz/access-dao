package br.com.bb.dao;

import br.com.bb.entities.User;

public interface UserDAO {

    Boolean persist(User user);

    void delete(Long userId);

    void update(User user);

    User find(Long userId);

}
