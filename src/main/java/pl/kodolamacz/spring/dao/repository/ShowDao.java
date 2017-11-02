package pl.kodolamacz.spring.dao.repository;

import pl.kodolamacz.spring.dao.model.Show;

import java.util.List;

public interface ShowDao extends AbstractDao<Show> {

    List<Show> findByMovieTitle(String movieTitle);

}
