package mingeso.mingeso;

import mingeso.mingeso.models.Client;
import mingeso.mingeso.models.Reservation;
import mingeso.mingeso.models.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.ArrayList;

@ExtendWith(SpringExtension.class)
@SpringBootTest
    public class ReservationTest {

    private Reservation reservation;

    private Client client;

    private ArrayList<Room> rooms;

    @BeforeEach
    public void initializeReservation() {
        reservation = new Reservation();
        client = new Client();
        rooms = new ArrayList<>();
        Room room = new Room();
        long reservationId = 5;
        client.setClientId(reservationId);
        room.setRoomId(reservationId);
        rooms.add(room);
        reservation.setState(1);
        Date date = java.sql.Date.valueOf("2019-03-13");
        reservation.setReservationId(reservationId);
        reservation.setClient(client);
        reservation.setRoomList(rooms);
    }

    @Test
    @DisplayName("Test for get estate")
    public void getStateTest() {
        Assertions.assertEquals(1, reservation.getState());
    }

    @Test
    @DisplayName("Test for get reservationId")
    public void getReservationIdTest() {
        long reservationId = 5;
        long realReservationId = reservation.getReservationId();
        Assertions.assertEquals(reservationId, realReservationId);
    }


    @Test
    @DisplayName("Test for get client")
    public void getClientTest() {
        Assertions.assertEquals(client, reservation.getClient());
    }

    @Test
    @DisplayName("Test for get rooms")
    public void getRoomsTest() {
        Assertions.assertEquals(rooms, reservation.getRoomList());
    }
}
