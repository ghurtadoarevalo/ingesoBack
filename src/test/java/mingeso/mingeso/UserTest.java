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
public class UserTest {

    private User user;

    private History history;

    private Role role;

    private Reservation reservation;

    @BeforeEach
    public void initializeUser() {
        user = new User();
        long userId = 7;
        user.setName("Matias");
        user.setContact("60593895");
        user.setMail("Matias@matias.cl");
        user.setPassword("ricolino");
        user.setRut("1235678-2");
        user.setUserId(userId);
        user.setPassport("029123");

        history = new History("Hola", user);
        role = new Role(0, user);
        Date date = java.sql.Date.valueOf("2019-03-13");
        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Reservation> reservations = new ArrayList<>();
        reservation = new Reservation(date, date, 0, user, rooms);
        reservations.add(reservation);
        user.setHistory(history);
        user.setRole(role);
        user.setReservationList(reservations);
    }

    @Test
    @DisplayName("Test for get user id")
    public void getUserIdTest() {
        long userId = 7;
        long realUserId = user.getUserId();
        Assertions.assertEquals(userId, realUserId);
    }

    @Test
    @DisplayName("Test for get user name")
    public void getUserNameTest() {
        Assertions.assertEquals("Matias", user.getName());
    }

    @Test
    @DisplayName("Test for get user contact")
    public void getUserContactTest() {
        Assertions.assertEquals("60593895", user.getContact());
    }

    @Test
    @DisplayName("Test for get user mail")
    public void getUserMailTest() {
        Assertions.assertEquals("Matias@matias.cl", user.getMail());
    }

    @Test
    @DisplayName("Test for get user rut")
    public void getUserRutTest() {
        Assertions.assertEquals("1235678-2", user.getRut());
    }

    @Test
    @DisplayName("Test for get user password")
    public void getUserPassword() {
        Assertions.assertEquals("ricolino", user.getPassword());
    }

    @Test
    @DisplayName("Test for get passport")
    public void getUserPassport() {
        Assertions.assertEquals("029123", user.getPassport());
    }

    @Test
    @DisplayName("Test for set and get history")
    public void setAndGetHistory() {
        Assertions.assertEquals(history, user.getHistory());
    }

    @Test
    @DisplayName("Test for get role")
    public void getRoleTest() {
        Assertions.assertEquals(role, user.getRole());
    }

    @Test
    @DisplayName("Test for get reservation list")
    public void getReservationTest() {
        Assertions.assertEquals(reservation, user.getReservationList().get(0));
    }
}
