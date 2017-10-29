package pl.kodolamacz.spring.dao.model;

import java.util.Date;

public class Show extends Entity{

  private Date date;

  private Movie movie;
  private Room room;

  public Show(Long id, Date date, Movie movie, Room room) {
    super(id);
    this.date = date;
    this.movie = movie;
    this.room = room;
  }
}
