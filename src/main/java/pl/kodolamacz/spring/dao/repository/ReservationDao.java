package pl.kodolamacz.spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kodolamacz.spring.dao.model.Reservation;
import pl.kodolamacz.spring.dao.model.Show;
import pl.kodolamacz.spring.dao.model.User;

import java.util.List;

@Repository
public interface ReservationDao extends JpaRepository<Reservation, Long> {

    List<Reservation> findByUser(User user);

    List<Reservation> findByShow(Show show);

    List<Reservation> findByUserId(Long id);

}
