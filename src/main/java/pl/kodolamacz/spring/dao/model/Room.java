package pl.kodolamacz.spring.dao.model;

import java.util.List;

public class Room extends AbstractEntity {

    private int number;
    private int capacity;

    public Room(int number, int capacity) {
        this.number = number;
        this.capacity = capacity;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
