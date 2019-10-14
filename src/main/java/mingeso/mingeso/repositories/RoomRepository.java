package mingeso.mingeso.repositories;

import mingeso.mingeso.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByRoomId(Long roomId);
}
