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
        room.setAdultCapacity(5);
        room.setChildCapacity(5);
        room.setPrice(3000);
        room.setType(2);
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
}
