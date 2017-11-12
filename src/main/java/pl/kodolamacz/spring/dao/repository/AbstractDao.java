package pl.kodolamacz.spring.dao.repository;

import pl.kodolamacz.spring.dao.model.AbstractEntity;

public interface AbstractDao<T extends AbstractEntity> {

    T findById(Long id);

    void save(T entity);

}
