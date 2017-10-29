package pl.kodolamacz.spring.dao.model;

import pl.kodolamacz.spring.dao.model.helpers.Status;

public class Reservation extends Entity{

  private Status status;

  private User user;
  private Show show;

  public Reservation(Long id, Status status, User user, Show show) {
    super(id);
    this.status = status;
    this.user = user;
    this.show = show;
  }
}
