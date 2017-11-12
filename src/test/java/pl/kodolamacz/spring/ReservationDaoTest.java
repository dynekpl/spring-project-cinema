package pl.kodolamacz.spring;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.kodolamacz.spring.dao.model.*;
import pl.kodolamacz.spring.dao.repository.ReservationDao;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;


//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class ReservationDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Value("#{new java.util.Date()}")
    private Date date;

    private Reservation reservation;

    @Autowired
    private ReservationDao reservationDao;

    @Before
    public void init() {

        User user = new User("cacko@arek.pl", "pass");
        //userDao.save(user);

        Movie titanic = new Movie("Titanic2", 2000);
//        movieDao.save(titanic);

        Room room = new Room(3, 50);
//        roomDao.save(room);

        Show show = new Show(date, titanic, room);
//        Show showFromDatabase = showDao.save(show);

        reservation = new Reservation(user, show);
        reservationDao.save(reservation);
    }


    @Test
    public void simpleFindTest() {
        User user = reservation.getUser();
        String email = user.getEmail();
        String title = reservation.getShow().getMovie().getTitle();
        int number = reservation.getShow().getRoom().getNumber();
        Date date = reservation.getShow().getDate();

        List<Reservation> foundReservations = reservationDao.findByUser(user);

        Predicate<Reservation> isReservationFound = res -> res.getUser().getEmail().equals(email)
                && res.getShow().getDate().equals(date)
                && res.getShow().getMovie().getTitle().equals(title)
                && res.getShow().getRoom().getNumber() == number;

        Optional<Reservation> foundReservation = foundReservations
                .stream()
                .filter(isReservationFound)
                .findFirst();

        assertTrue(foundReservation.isPresent());
    }

}
