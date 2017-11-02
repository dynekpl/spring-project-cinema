package pl.kodolamacz.spring.dao.repository.impl;

import org.springframework.stereotype.Repository;
import pl.kodolamacz.spring.dao.model.Reservation;
import pl.kodolamacz.spring.dao.model.Show;
import pl.kodolamacz.spring.dao.model.User;
import pl.kodolamacz.spring.dao.repository.AbstractDao;
import pl.kodolamacz.spring.dao.repository.ReservationDao;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ReservationDaoImpl extends AbstractDaoImpl<Reservation> implements ReservationDao {

    @Override
    public List<Reservation> findByUser(User user) {
        return entityMap.values()
                .stream()
                .filter(reservation -> reservation.getUser().equals(user))
                .collect(Collectors.toList());
    }

    @Override
    public List<Reservation> findByShow(Show show) {
        return entityMap.values()
                .stream()
                .filter(reservation -> reservation.getShow().equals(show))
                .collect(Collectors.toList());
    }
}
