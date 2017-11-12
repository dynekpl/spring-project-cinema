package pl.kodolamacz.spring.dao.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import pl.kodolamacz.spring.dao.model.AbstractEntity;
import pl.kodolamacz.spring.dao.repository.AbstractDao;
import pl.kodolamacz.spring.dao.tools.Generator;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractDaoImpl<T extends AbstractEntity> implements AbstractDao<T> {

//    @Autowired
//    protected NamedParameterJdbcTemplate jdbcTemplate;

  @Autowired
  protected SessionFactory sessionFactory;

  protected Class<T> clazz;

  public void setClazz(Class<T> clazz) {
    this.clazz = clazz;
  }

  public Class<T> getClazz() {
    return clazz;
  }

  Map<Long, T> entityMap = new HashMap<>();

  @Autowired
  private Generator generator;

  public T findById(Long id) {
    return entityMap.get(id);
  }

  public void save(T entity) {
    entity.setId(generator.getUniqueId());
    entityMap.put(entity.getId(), entity);
  }

  public Session getCurrentSession() {
    return sessionFactory.getCurrentSession();
  }

  public List<T> findAll() {
    // zapytanie o wiele
    return getCurrentSession().createQuery("from " + clazz, clazz).getResultList();
  }
}
