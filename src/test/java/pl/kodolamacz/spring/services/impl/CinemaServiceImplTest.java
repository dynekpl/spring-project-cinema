package pl.kodolamacz.spring.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import pl.kodolamacz.spring.dao.model.*;
import pl.kodolamacz.spring.dao.repository.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static org.testng.Assert.*;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

@ContextConfiguration(locations = {"classpath:application.xml"})
public class CinemaServiceImplTest extends AbstractTestNGSpringContextTests {

  @Autowired
  private UserDao userDao;

  @Autowired
  private MovieDao movieDao;

  @Autowired
  private ShowDao showDao;

  @Autowired
  private RoomDao roomDao;

  @Autowired
  private ReservationDao reservationDao;

  @Autowired
  private CinemaServiceImpl cinemaService;

  @Test
  public void testCreateUser() throws Exception {
    //given
    String email = "dyneck@abc.pl";
    String password = "admin";

    //when
    cinemaService.createUser(email, password);

    //then
    User foundUser = userDao.findByEmail(email);
    assertEquals(foundUser.getEmail(), email);
  }

  @Test
  public void testCreateShow() throws Exception {
    //given
    String title = "Pitbull";
    Movie movie = new Movie(title, 200);
    movieDao.save(movie);
    int number = 1;
    Room room = new Room(number, 100);
    roomDao.save(room);

    Date date = Calendar.getInstance().getTime();
    Show expectedShow = new Show(date, movie, room);

    //when
    cinemaService.createShow(date, title, number);

    //then
    List<Show> foundShows = showDao.findByMovieTitle(title);

    Predicate<Show> isShowFound = show -> show.getDate().equals(date)
            && show.getMovie().getTitle().equals(title)
            && show.getRoom().getNumber() == number;

    Optional<Show> foundShow = foundShows
            .stream()
            .filter(isShowFound)
            .findFirst();

    assertTrue(foundShow.isPresent());
  }

  @Test
  public void testCreateReservation() throws Exception {
    //given
    String email = "kris@abc.pl";
    User user = new User(email, "pass123");
    String title = "Botoks";
    Movie movie = new Movie(title, 200);
    int number = 7;
    Room room = new Room(number, 40);
    Date date = Calendar.getInstance().getTime();
    Show show = new Show(date, movie, room);

    //when
    cinemaService.createReservation(user, show);

    //then
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

  @Test
  public void testCreateMovie() throws Exception {
    //given
    String title = "Botoks";
    int price = 200;

    //when
    cinemaService.createMovie(title, price);

    //then
    Movie foundMovie = movieDao.findByTitle(title);
    assertEquals(foundMovie.getTitle(), title);
  }

}