package pl.kodolamacz.spring.dao.repository.impl;

import org.springframework.stereotype.Repository;
import pl.kodolamacz.spring.dao.model.Room;
import pl.kodolamacz.spring.dao.repository.RoomDao;

@Repository
public class RoomDaoImpl extends AbstractDaoImpl<Room> implements RoomDao {

    @Override
    public Room findByRoomNumber(int number) {
        return entityMap.values()
                .stream()
                .filter(room -> room.getNumber() == number)
                .findFirst()
                .orElse(null);
    }
}
