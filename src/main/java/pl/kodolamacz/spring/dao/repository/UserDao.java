package pl.kodolamacz.spring.dao.repository;

import pl.kodolamacz.spring.dao.model.User;

public interface UserDao extends AbstractDao<User> {

    User findUser(String email);

}
