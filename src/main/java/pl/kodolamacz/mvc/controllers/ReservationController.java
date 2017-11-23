package pl.kodolamacz.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kodolamacz.spring.dao.repository.ReservationDao;
import pl.kodolamacz.spring.dao.repository.UserDao;

@Controller
@RequestMapping(value = "/reservations")
public class ReservationController {

  @Autowired
  private ReservationDao reservationDao;

  @Autowired
  private UserDao userDao;

  @RequestMapping(method = RequestMethod.GET)
  public void get(Model model) {
    System.out.println("Wywołanie /reservations");
  }

  // przykład adresu: http://localhost:8080/kino/reservations/byUser?userId=1
  @RequestMapping(value = "/byUsers", method = RequestMethod.GET)
  public String getReservationsByUserId(Model model, @RequestParam("userId") Long userId) {
    // Jeśli paramName oraz nazwa zmiennej się pokrywają
    // to można pominąć deklarację nazwy zmiennej w @RequestParam
    model.addAttribute("userReservations", reservationDao.findByUserId(userId));
    model.addAttribute("user", userDao.findOne(userId));
    return "reservations";
  }

  // przykład adresu: http://localhost:8080/kino/reservations/byUser2/2
  @RequestMapping(value = "/byUser/{userId}", method = RequestMethod.GET)
  public String getReservationsByUserId2(Model model, @PathVariable("userId") Long userId) { // parametrów może być więcej
    // Jeśli paramName oraz nazwa zmiennej się pokrywają
    // to można pominąć deklarację nazwy zmiennej w @Pathvariable
    // wiecej parametrów np.: http://localhost:8080/kino/reservations/byUser2/2/Arek/1988
    model.addAttribute("userReservations", reservationDao.findByUserId(userId));
    model.addAttribute("user", userDao.findOne(userId));
    return "reservations";
  }
}
