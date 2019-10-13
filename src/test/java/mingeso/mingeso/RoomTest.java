package mingeso.mingeso;

import mingeso.mingeso.models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RoomTest {

    private Room room;

    private Reservation reservation;

    private Hotel hotel;

    private ArrayList<ServiceRoom> serviceRooms;

    private RoomReservation roomReservation;

    private List<RoomReservation> roomReservationList;

    @BeforeEach
    public void initializeRoom() {
        long serviceId = 7;
        room = new Room();
        reservation = new Reservation();
        hotel = new Hotel();
        roomReservation = new RoomReservation();
        roomReservationList = new ArrayList<>();

        ServiceRoomKey serviceRoomKey = new ServiceRoomKey();
        Service service = new Service();
        service.setServiceId(serviceId);
        ServiceRoom serviceRoom = new ServiceRoom();
        serviceRoom.setSrId(serviceRoomKey);
        Date date = java.sql.Date.valueOf("2019-03-13");
        serviceRoom.setDate(date);
        serviceRooms = new ArrayList<>();
        serviceRooms.add(serviceRoom);
        long roomId = 7;
        reservation.setReservationId(roomId);
        hotel.setHotelId(roomId);
        room.setRoomId(roomId);
        room.setAdultCapacity(5);
        room.setChildCapacity(5);
        room.setPrice(3000);
        room.setType(2);
        room.setRoomNumber(101);
        room.setImageLink("https://hotelvarunamanizales.com/wp-content/uploads/2016/02/habitacion-superior-sencilla-hotel-manizales-varuna-4.jpg");
        roomReservation.setRoom(room);
        roomReservation.setReservation(reservation);
        roomReservationList.add(roomReservation);
        room.setRoomReservations(roomReservationList);
        room.setHotel(hotel);
        room.setServiceRooms(serviceRooms);
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

    @Test
    @DisplayName("Test for get reservation")
    public void getReservationTest() {
        Assertions.assertEquals(roomReservationList, room.getRoomReservations());
    }

    @Test
    @DisplayName("Test for get hotel")
    public void getHotelTest() {
        Assertions.assertEquals(hotel, room.getHotel());
    }

    @Test
    @DisplayName("Test for get service rooms")
    public void getServiceRooms() {
        Assertions.assertEquals(serviceRooms, room.getServiceRooms());
    }
}
