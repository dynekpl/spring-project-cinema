package pl.kodolamacz.spring.dao.repository;

import pl.kodolamacz.spring.dao.model.User;

import java.util.List;

public interface UserDao extends AbstractDao<User> {

    User findUser(String email);

    List<User> findAll();

}
