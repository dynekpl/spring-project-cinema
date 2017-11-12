package pl.kodolamacz.spring;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.kodolamacz.spring.dao.model.Movie;
import pl.kodolamacz.spring.dao.repository.MovieDao;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by acacko on 28.10.17
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
@Transactional
public class MovieDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private MovieDao movieDao;

    private Movie movie;

    @Before
    public void init() {
        movie = new Movie("Film1", 1000);
        movieDao.save(movie);
    }


    @Test
    public void simpleFindTest() {
        assertThat(movieDao.findAll()).isNotEmpty();
    }

    @Test
    public void findByTitleTest() {
        assertThat(movieDao.findByTitle("Film1")).isNotNull();
        assertThat(movieDao.findByTitle("Film1").getTitle()).isEqualTo("Film1");
    }

    @Test
    public void findMovieByPrice() {
        assertThat(movieDao.findByPrice(1000)).isNotNull();
    }

    @Test
    public void findUserByNotExistingTitle() {
        assertThat(movieDao.findByTitle("xxxx")).isNull();
    }

    @Test
    public void saveTest() {
        long countBefore = movieDao.count();
        Movie movie = new Movie("Film2", 1500);
        movieDao.save(movie);
        assertThat(movie).isNotNull();
        assertThat(movie.getId()).isNotNull();

        long countAfter = movieDao.count();

        assertThat(countBefore).isLessThan(countAfter);
        assertThat(countBefore).isEqualTo(countAfter - 1);

    }

    @Test
    public void deleteTest() {

        long countBefore = movieDao.count();

        Movie one = movieDao.findOne(movie.getId());
        movieDao.delete(one);

        long countAfter = movieDao.count();
        assertThat(countBefore).isGreaterThan(countAfter);

        assertThat(movieDao.findOne(movie.getId())).isNull();
    }
}

