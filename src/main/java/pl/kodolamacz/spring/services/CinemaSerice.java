package pl.kodolamacz.spring.services;

import pl.kodolamacz.spring.dao.model.Show;
import pl.kodolamacz.spring.dao.model.User;

import java.util.Date;

/**
 * Created by acacko on 29.10.17
 */
public interface CinemaSerice {

    // Zadanko na ten tydzień -> doimplementować
    // funkcjonalności biznesowe
    // rzucać WŁASNYMI wyjątkami jeśli akcja się nie powiodła
    // I jeszcze testy do tego!

    // 0. Utworzenie użytkownika
    void createUser(String email, String password);

    // 1. Metoda na sprawdzenie czy user to user
    boolean checkUser(String email, String password);

    // 2. Utworzenie emisji filmu
    void createShow(Date date, String movieTitle, int roomNumber);

    // 3. Utworzenie rezerwacji
    void createReservation(User user, Show show);

    // 4. Utworzenie filmu
    void createMovie(String title, int price);

}
