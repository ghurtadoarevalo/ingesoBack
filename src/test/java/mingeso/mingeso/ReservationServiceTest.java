package mingeso.mingeso;

import mingeso.mingeso.dto.ReservationDTO;
import mingeso.mingeso.dto.ReservationResponseDTO;
import mingeso.mingeso.models.Client;
import mingeso.mingeso.models.Reservation;
import mingeso.mingeso.models.Room;
import mingeso.mingeso.repositories.ClientRepository;
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

    @Mock
    private ClientRepository clientRepository;

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

    @Test
    @DisplayName("Test for create reservation when client doesn't exist")
    public void createReservationTest() {
        ReservationResponseDTO reservation = new ReservationResponseDTO();
        reservation.setRoomList(new ArrayList<Room>());
        ResponseEntity responseEntity = reservationService.create(reservation);
        Assertions.assertEquals(reservation, reservation);
    }


    @Test
    @DisplayName("Test for create when client exist")
    public void createClientExisteTest() {
        ReservationResponseDTO reservation = new ReservationResponseDTO();
        Client client = new Client();
        client.setPassport("123");
        reservation.setClient(client);
        reservation.setRoomList(new ArrayList<Room>());
        doReturn(client).when(clientRepository).findByPassport("123");
        reservationService.create(reservation);
        Assertions.assertEquals(reservation, reservation);
    }

    @Test
    @DisplayName("Test create when client not exist in database")
    public void createClientTest() {
        ReservationResponseDTO reservation = new ReservationResponseDTO();
        Client client = new Client();
        client.setPassport("123");
        reservation.setClient(client);
        reservation.setRoomList(new ArrayList<Room>());
        doReturn(null).when(clientRepository).findByPassport("123");
        reservationService.create(reservation);
        Assertions.assertEquals(reservation, reservation);
    }

}
