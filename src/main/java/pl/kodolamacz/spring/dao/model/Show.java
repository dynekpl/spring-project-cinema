package pl.kodolamacz.spring.dao.model;

import java.util.Date;

public class Show extends AbstractEntity {

    private Date date;

    private Movie movie;
    private Room room;

    public Show(Date date, Movie movie, Room room) {
        this.date = date;
        this.movie = movie;
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
