package mingeso.mingeso;

import mingeso.mingeso.models.Reservation;
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
    public class ReservationTest {

    private Reservation reservation;

    @BeforeEach
    public void initializeReservation() {
        reservation = new Reservation();
        long reservationId = 5;
        reservation.setEstate("Santiago");
        Date date = java.sql.Date.valueOf("2019-03-13");
        reservation.setFinalDate(date);
        reservation.setReservationId(reservationId);
        reservation.setInitialDate(date);
    }

    @Test
    @DisplayName("Test for get estate")
    public void getStateTest() {
        Assertions.assertEquals("Santiago", reservation.getEstate());
    }

    @Test
    @DisplayName("Test for get reservationId")
    public void getReservationIdTest() {
        long reservationId = 5;
        long realReservationId = reservation.getReservationId();
        Assertions.assertEquals(reservationId, realReservationId);
    }

    @Test
    @DisplayName("Test for get initial Date")
    public void getInitialDateTest() {
        Date date = java.sql.Date.valueOf("2019-03-13");
        Assertions.assertEquals(date, reservation.getInitialDate());
    }

    @Test
    @DisplayName("Test for get final date")
    public void getFinalDateTest() {
        Date date = java.sql.Date.valueOf("2019-03-13");
        Assertions.assertEquals(date, reservation.getFinalDate());
    }
}
