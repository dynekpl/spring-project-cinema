package pl.kodolamacz.spring.dao.model;

import pl.kodolamacz.spring.dao.model.helpers.Status;

public class Reservation extends AbstractEntity {

    private Status status = Status.WAITING;

    private User user;
    private Show show;

    public Reservation(User user, Show show) {
        this.user = user;
        this.show = show;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "status=" + status +
                ", user=" + user +
                ", show=" + show +
                '}';
    }
}
