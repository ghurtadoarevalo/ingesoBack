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

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserTest {

    private Client client;

    private History history;

    private Reservation reservation;

    @BeforeEach
    public void initializeUser() {
        client = new Client();
        long userId = 7;
        client.setName("Matias");
        client.setContact("60593895");
        client.setMail("Matias@matias.cl");
        client.setClientId(userId);
        client.setPassport("029123");

        history = new History("Hola", client);
        Date initialDate = java.sql.Date.valueOf("2019-03-13");
        Date finalDate = java.sql.Date.valueOf("2019-03-14");
        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Reservation> reservations = new ArrayList<>();
        reservation = new Reservation(0, client, rooms,initialDate,finalDate);
        reservations.add(reservation);
        client.setHistory(history);
        client.setReservationList(reservations);
    }

    @Test
    @DisplayName("Test for get user id")
    public void getClientIdTest() {
        long clientId = 7;
        long realClientId = client.getClientId();
        Assertions.assertEquals(clientId, realClientId);
    }

    @Test
    @DisplayName("Test for get user name")
    public void getClientNameTest() {
        Assertions.assertEquals("Matias", client.getName());
    }

    @Test
    @DisplayName("Test for get user contact")
    public void getClientContactTest() {
        Assertions.assertEquals("60593895", client.getContact());
    }

    @Test
    @DisplayName("Test for get user mail")
    public void getClientMailTest() {
        Assertions.assertEquals("Matias@matias.cl", client.getMail());
    }

    @Test
    @DisplayName("Test for get passport")
    public void getClientPassport() {
        Assertions.assertEquals("029123", client.getPassport());
    }

    @Test
    @DisplayName("Test for set and get history")
    public void setAndGetHistory() {
        Assertions.assertEquals(history, client.getHistory());
    }

    @Test
    @DisplayName("Test for get reservation list")
    public void getReservationTest() {
        Assertions.assertEquals(reservation, client.getReservationList().get(0));
    }
}
