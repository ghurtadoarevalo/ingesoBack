package mingeso.mingeso;

import mingeso.mingeso.dto.ReservationDTO;
import mingeso.mingeso.models.Reservation;
import mingeso.mingeso.models.Room;
import mingeso.mingeso.repositories.ReservationRepository;
import mingeso.mingeso.services.ReservationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    @Test
    @DisplayName("Test for get all reservation")
    public void getAllTest() {
        Reservation reservation = new Reservation();
        doReturn(Arrays.asList(reservation)).when(reservationRepository).findAll();
        List<Reservation> reservations = reservationService.getAll();

        Assertions.assertEquals(1, reservations.size());
    }

    /*@Test
    @DisplayName("Test for create reservation")
    public void createReservationTest() {
        ReservationDTO reservation = new ReservationDTO();
        reservation.setRoomList(new ArrayList<Room>());
        when(reservationService.create(reservation)).thenReturn(new ResponseEntity(reservation, HttpStatus.CREATED));
        Assertions.assertEquals(reservation, reservation);
    }*/
}
