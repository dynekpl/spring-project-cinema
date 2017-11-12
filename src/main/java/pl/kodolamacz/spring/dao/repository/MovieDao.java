package pl.kodolamacz.spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kodolamacz.spring.dao.model.Movie;

@Repository
public interface MovieDao extends JpaRepository<Movie, Long> {

    Movie findByTitle(String title);
}
