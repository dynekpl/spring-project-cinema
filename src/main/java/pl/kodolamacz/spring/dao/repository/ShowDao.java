package pl.kodolamacz.spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kodolamacz.spring.dao.model.Show;

import java.util.List;

@Repository
public interface ShowDao extends JpaRepository<Show, Long> {

    List<Show> findByMovieTitle(String movieTitle);

}
