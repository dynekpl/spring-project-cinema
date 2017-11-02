package pl.kodolamacz.spring.dao.repository;

import pl.kodolamacz.spring.dao.model.Reservation;
import pl.kodolamacz.spring.dao.model.Show;
import pl.kodolamacz.spring.dao.model.User;

import java.util.List;

public interface ReservationDao extends AbstractDao<Reservation> {

    List<Reservation> findByUser(User user);

    List<Reservation> findByShow(Show show);

}
