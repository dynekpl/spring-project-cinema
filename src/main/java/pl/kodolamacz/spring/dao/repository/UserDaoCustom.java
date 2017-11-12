package pl.kodolamacz.spring.dao.repository;

import pl.kodolamacz.spring.dao.model.User;

public interface UserDaoCustom {

  User findByPass(String password);

}
