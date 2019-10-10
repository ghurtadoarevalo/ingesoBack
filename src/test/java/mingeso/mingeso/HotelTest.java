package mingeso.mingeso;

import mingeso.mingeso.models.Hotel;
import mingeso.mingeso.models.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HotelTest {

    private Hotel hotel;

    private Room room;

    private ArrayList<Room> rooms;

    @BeforeEach
    public void initializaHotel() {
        hotel = new Hotel();
        long hotelId = 5;
        hotel.setContact("91823747");
        hotel.setLocation("Santiago");
        hotel.setName("La Mision");
        hotel.setOwnerName("Jorge");
        hotel.setHotelId(hotelId);
        hotel.setImageLink("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR5Hn_Swn0JRT-I1VeDHOfZf7wrY3yUalgs3dbqeCdyoIMhjIXP");
        rooms = new ArrayList<>();
        room = new Room();
        room.setRoomId(hotelId);
        rooms.add(room);
        hotel.setRoomList(rooms);
    }

    @Test
    @DisplayName("Test for get hotel contact")
    public void getHotelContactTest() {
        Assertions.assertEquals("91823747", hotel.getContact());
    }

    @Test
    @DisplayName("Test for get hotel location")
    public void getHotelLocationTest() {
        Assertions.assertEquals("Santiago", hotel.getLocation());
    }

    @Test
    @DisplayName("Test for get hotel name")
    public void getHotelNameTest() {
        Assertions.assertEquals("La Mision", hotel.getName());
    }

    @Test
    @DisplayName("Test for get hotel id")
    public void getHotelIdTest() {
        long hotelId = 5;
        long realHotelId = hotel.getHotelId();
        Assertions.assertEquals(hotelId, realHotelId);
    }

    @Test
    @DisplayName("Test for get owner hotel name")
    public void getOwnerNameTest() {
        Assertions.assertEquals("Jorge", hotel.getOwnerName());
    }

    @Test
    @DisplayName("Test for get hotel image")
    public void getImageTest() {
        Assertions.assertEquals("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR5Hn_Swn0JRT-I1VeDHOfZf7wrY3yUalgs3dbqeCdyoIMhjIXP",
                                hotel.getImageLink());
    }

    @Test
    @DisplayName("Test for get room list")
    public void getRoomListTest() {
        Assertions.assertEquals(rooms, hotel.getRoomList());
    }
}
