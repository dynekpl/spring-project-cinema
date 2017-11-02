package pl.kodolamacz.spring.dao.repository;

import pl.kodolamacz.spring.dao.model.Entity;

public interface AbstractDao<T extends Entity> {

    T findById(Long id);

    void save(T entity);

}
