package pl.kodolamacz.spring.dao.repository.impl;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import pl.kodolamacz.spring.dao.model.User;
import pl.kodolamacz.spring.dao.repository.UserDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {

  private static final String FIND_BY_EMAIL = "select * from users where email = :email"; // :email - łyka NamedParameterJdbcTemplate
  private static final String FIND_ALL = "select * from users";

  private static final RowMapper<User> ROW_MAPPER = (rs, rowNum) -> new User(
          rs.getLong("id"),
          rs.getString("email"),
          rs.getString("password"));

  @Override
  public User findUser(String email) {
    // zapytanie o jeden
    return jdbcTemplate.queryForObject(FIND_BY_EMAIL, new MapSqlParameterSource("email", email), ROW_MAPPER);
  }

  @Override
  public List<User> findAll() {
    // zapytanie o wiel
    return jdbcTemplate.query(FIND_ALL, ROW_MAPPER);
  }

}
