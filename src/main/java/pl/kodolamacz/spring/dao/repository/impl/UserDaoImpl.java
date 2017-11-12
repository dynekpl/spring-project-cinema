package pl.kodolamacz.spring.dao.repository.impl;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.kodolamacz.spring.dao.model.User;
import pl.kodolamacz.spring.dao.repository.UserDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {

  public UserDaoImpl() {
    setClazz(User.class);
  }

  @Override
  public User findUser(String email) {
    return entityManager.createNamedQuery("User.byMail", clazz)
            .setParameter("email", email)
            .getResultList()
            .stream()
            .findFirst()
            .orElse(null);
  }
}
