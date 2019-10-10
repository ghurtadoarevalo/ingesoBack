package mingeso.mingeso;

import mingeso.mingeso.models.Room;
import mingeso.mingeso.repositories.HotelRepository;
import mingeso.mingeso.repositories.RoomRepository;
import mingeso.mingeso.services.RoomService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RoomServiceTest {

    @Mock
    private RoomRepository roomRepository;

    @MockBean
    private HotelRepository hotelRepository;

    @InjectMocks
    private RoomService roomService;

    @Test
    public void testFindAllRooms() throws Exception {
        Room room = new Room();
        Room room2 = new Room();
        room.setImageLink("Hola");
        room2.setImageLink("Chao");
        doReturn(Arrays.asList(room, room2)).when(roomRepository).findAll();

        List<Room> rooms = roomService.getAll();
        Assertions.assertEquals(2, rooms.size());
    }
}
