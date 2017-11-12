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

  private static final String FIND_BY_EMAIL = "select * from users where email = :email"; // :email - łyka NamedParameterJdbcTemplate
  private static final String FIND_ALL = "select * from users";

  public UserDaoImpl() {
    setClazz(User.class);
  }

  @Override
  public User findUser(String email) {
    return getCurrentSession().createQuery("select u from User u where u.email = :email", User.class)
            .setParameter("email", email)
            .getResultList()
            .stream()
            .findFirst()
            .orElse(null);
  }

  @Override
  public List<User> findAll() {
    return getCurrentSession().createQuery("select u from User u", User.class).getResultList();
  }

}
