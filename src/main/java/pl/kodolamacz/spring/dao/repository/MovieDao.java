package pl.kodolamacz.spring.dao.repository;

import pl.kodolamacz.spring.dao.model.Movie;

public interface MovieDao extends AbstractDao<Movie>{

    Movie findByTitle(String title);
}
