package mingeso.mingeso;

import mingeso.mingeso.models.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RoomTest {

    private Room room;

    @BeforeEach
    public void initializeRoom() {
        room = new Room();
        long roomId = 7;
        room.setRoomId(roomId);
        room.setAdultCapacity(5);
        room.setChildCapacity(5);
        room.setPrice(3000);
        room.setType(2);
        room.setRoomNumber(101);
        room.setImageLink("https://hotelvarunamanizales.com/wp-content/uploads/2016/02/habitacion-superior-sencilla-hotel-manizales-varuna-4.jpg");
    }

    @Test
    @DisplayName("Test for get child capacity method")
    public void childGetCapacityTest() {
        Assertions.assertEquals(5, room.getChildCapacity());
    }

    @Test
    @DisplayName("Test for get Adult capacity method")
    public void adultGetCapacityTest() {
        Assertions.assertEquals(5, room.getAdultCapacity());
    }

    @Test
    @DisplayName("Test for get price of room")
    public void getPriceTest() {
        Assertions.assertEquals(3000, room.getPrice());
    }

    @Test
    @DisplayName("Test for get room number")
    public void getRoomNumberTest() {
        Assertions.assertEquals(101, room.getRoomNumber());
    }

    @Test
    @DisplayName("Test for get room type")
    public void getRoomTypeTest() {
        Assertions.assertEquals(2, room.getType());
    }

    @Test
    @DisplayName("Test for get image link")
    public void getImageLinkTest() {
        Assertions.assertEquals("https://hotelvarunamanizales.com/wp-content/uploads/2016/02/habitacion-superior-sencilla-hotel-manizales-varuna-4.jpg",
                                room.getImageLink());
    }

    @Test
    @DisplayName("Test for get room id")
    public void getRoomIdTest() {
        long roomId = 7;
        long realRoomId = room.getRoomId();
        Assertions.assertEquals(roomId, realRoomId);
    }
}
