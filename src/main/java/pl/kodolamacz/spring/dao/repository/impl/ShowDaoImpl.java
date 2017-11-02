package pl.kodolamacz.spring.dao.repository.impl;

import org.springframework.stereotype.Repository;
import pl.kodolamacz.spring.dao.model.Show;
import pl.kodolamacz.spring.dao.repository.ShowDao;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ShowDaoImpl extends AbstractDaoImpl<Show> implements ShowDao {
    @Override
    public List<Show> findByMovieTitle(String movieTitle) {
        return entityMap.values()
                .stream()
                .filter(show -> show.getMovie().getTitle().equals(movieTitle))
                .collect(Collectors.toList());
    }
}
