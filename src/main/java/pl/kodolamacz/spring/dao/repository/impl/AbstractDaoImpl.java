package pl.kodolamacz.spring.dao.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.kodolamacz.spring.dao.model.Entity;
import pl.kodolamacz.spring.dao.repository.AbstractDao;
import pl.kodolamacz.spring.dao.tools.Generator;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDaoImpl<T extends Entity> implements AbstractDao<T> {

  @Autowired
  private DataSource dataSource;

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
}
