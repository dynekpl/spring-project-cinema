package pl.kodolamacz.spring.dao.repository;

import pl.kodolamacz.spring.dao.model.Room;

public interface RoomDao extends AbstractDao<Room> {

    Room findByRoomNumber(int number);

}
