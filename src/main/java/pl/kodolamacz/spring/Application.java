package pl.kodolamacz.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.kodolamacz.spring.dao.model.*;
import pl.kodolamacz.spring.dao.repository.*;

import java.util.Calendar;
import java.util.Date;

@Component
public class Application {

  @Value("${app.name:defaultAppName}") // #{} - SpEL, ${} - propertisy
          String appName;

  @Value("${app.version}")
  int version;

  //wywołanie metody/konstruktora na obiekcie
  @Value("#{new java.util.Date()}")
  private Date date;

  //wywołanie metody na beanie
  @Value("#{idSequenceGenerator.version}")
  private int generatorVersion;

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

  public void simulate() {

    User user = userDao.findByEmail("arek@cacko.pl");
    System.out.println("Odczytano z bazy: " + user);

    System.out.println("Odczytano z bazy wszystkie: " + userDao.findAll());

    User arek = new User("cacko@arek.pl", "pass");
    //userDao.save(arek);

    Movie titanic = new Movie("Titanic", 2000);
    //movieDao.save(titanic);

    Room room = new Room(1, 50);
    //roomDao.save(room);

    Show show = new Show(Calendar.getInstance().getTime(), titanic, room);
    //showDao.save(show);

    Reservation reservation = new Reservation(arek, show);
    //reservationDao.save(reservation);

    // ---------------------

    //Reservation reservationDaoById = reservationDao.findOne(reservation.getId());
    //System.out.println(reservation);

    System.out.println("Spring data room test: " + roomDao.findByCapacity(250));
    System.out.println("Spring data custom method: " + userDao.findByPass("myPassword"));

  }
}
