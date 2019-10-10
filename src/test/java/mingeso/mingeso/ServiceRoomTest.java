package mingeso.mingeso;

import mingeso.mingeso.models.Room;
import mingeso.mingeso.models.Service;
import mingeso.mingeso.models.ServiceRoom;
import mingeso.mingeso.models.ServiceRoomKey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ServiceRoomTest {

    private ServiceRoom serviceRoom;

    private Room room;

    private Service service;

    private ServiceRoomKey serviceRoomKey;

    @BeforeEach
    public void initialize() {
        serviceRoom = new ServiceRoom();
        room = new Room();
        service = new Service();
        serviceRoomKey = new ServiceRoomKey();
        long id = 5;
        Date date = java.sql.Date.valueOf("2019-03-13");
        serviceRoom.setDate(date);
        room.setRoomId(id);
        serviceRoom.setRoom(room);
        service.setServiceId(id);
        serviceRoom.setService(service);
        serviceRoomKey.setRoomId(id);
        serviceRoom.setSrId(serviceRoomKey);
    }

    @Test
    @DisplayName("Test for get service")
    public void getServiceTest() {
        Assertions.assertEquals(service, serviceRoom.getService());
    }

    @Test
    @DisplayName("Test for get id")
    public void getIdTest() {
        Assertions.assertEquals(serviceRoomKey, serviceRoom.getSrId());
    }

    @Test
    @DisplayName("Test for get Date")
    public void getDateTest() {
        Date date = java.sql.Date.valueOf("2019-03-13");
        Assertions.assertEquals(date, serviceRoom.getDate());
    }

    @Test
    @DisplayName("Test for get room")
    public void getRoomTest() {
        Assertions.assertEquals(room, serviceRoom.getRoom());
    }
}
