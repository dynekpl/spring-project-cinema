package pl.kodolamacz.spring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.kodolamacz.spring.dao.model.Movie;
import pl.kodolamacz.spring.dao.model.Room;
import pl.kodolamacz.spring.dao.model.Show;
import pl.kodolamacz.spring.dao.repository.ShowDao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
@Transactional
public class ShowDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private ShowDao showDao;

    private Show show;

    @Before
    public void init() {
        Movie tranformers = new Movie("Transformers", 2000);
        Room room = new Room(43, 150);
        show = new Show(Calendar.getInstance().getTime(),tranformers,room);
        showDao.save(show);
        // tutaj inicjujemy start testów (kontekst testu)
    }

    @Test
    public void simpleFindTest() {
        assertThat(showDao.findAll()).isNotEmpty();
    }

    @Test
    public void findByMovieTitle() {
        assertThat(showDao.findByMovieTitle("Transformers")).isNotNull();

    }

    @Test
    public void saveTest() {
        long countBefore = showDao.count();
        Movie tranformers = new Movie("Transformers2", 2000);
        Room room = new Room(44, 150);
        Show show = new Show(Calendar.getInstance().getTime(), tranformers,room);
        showDao.save(show);
        assertThat(show).isNotNull();
        assertThat(show.getId()).isNotNull();

        long countAfter = showDao.count();

        assertThat(countBefore).isLessThan(countAfter);
        assertThat(countBefore).isEqualTo(countAfter - 1);

    }

    @Test
    public void deleteTest() {

        long countBefore = showDao.count();

        Show one = showDao.findOne(show.getMovie().getId());
        showDao.delete(one);

        // tożsame z :
        //userDao.delete(one.getId());

        long countAfter = showDao.count();
        assertThat(countBefore).isGreaterThan(countAfter);
        assertThat(showDao.findOne(show.getId())).isNull();

    }

    @Test
    public void dateBetweenTest() {
//        Movie tranformers = new Movie("Transformers", 2000);
//        Room room = new Room(43, 150);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, -1);

        Date time = calendar.getTime();

        calendar.add(Calendar.HOUR_OF_DAY, 2);

        Date time2 = calendar.getTime();

        List<Show> byDateBetween = showDao.findByDateBetween(time, time2);

        assertThat(byDateBetween).isNotEmpty();
        assertThat(byDateBetween.size()).isEqualTo(1);
    }
}