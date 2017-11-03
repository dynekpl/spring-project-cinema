package pl.kodolamacz.spring.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kodolamacz.spring.dao.model.*;
import pl.kodolamacz.spring.dao.repository.*;
import pl.kodolamacz.spring.services.CinemaSerice;

import java.util.Date;

@Component
public class CinemaServiceImpl implements CinemaSerice{

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

  @Override
  public void createUser(String email, String password) {
    User user = new User(email, password);
    userDao.save(user);
  }

  @Override
  public boolean checkUser(String email, String password) {
    //TODO try-catch
    User user = userDao.findUser(email);
    return user.getPassword().equals(password) ? true : false;
  }

  @Override
  public void createShow(Date date, String movieTitle, int roomNumber) {
    //TODO try-catch
    Movie movie = movieDao.findByTitle(movieTitle);
    Room room = roomDao.findByRoomNumber(roomNumber);

    Show show = new Show(date, movie, room);
    showDao.save(show);
  }

  @Override
  public void createReservation(User user, Show show) {
    Reservation reservation = new Reservation(user, show);
    reservationDao.save(reservation);
  }

  @Override
  public void createMovie(String title, int price) {
    Movie movie = new Movie(title, price);
    movieDao.save(movie);
  }
}
