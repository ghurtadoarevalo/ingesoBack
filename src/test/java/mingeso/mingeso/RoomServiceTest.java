package mingeso.mingeso;

import mingeso.mingeso.dto.ReservationDTO;
import mingeso.mingeso.dto.ReservationResponseDTO;
import mingeso.mingeso.dto.RoomDTO;
import mingeso.mingeso.models.*;
import mingeso.mingeso.repositories.HotelRepository;
import mingeso.mingeso.repositories.RoomRepository;
import mingeso.mingeso.services.RoomService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.longThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RoomServiceTest {

    @Mock
    private RoomRepository roomRepository;

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

    @Test
    @DisplayName("test for get by id")
    public void getByIdTest() throws Exception {
        Room room = new Room();
        Room room1 = new Room();
        long id = 5;
        room.setRoomId(id);
        room.setImageLink("Hola");
        doReturn(Optional.of(room)).when(roomRepository).findById(id);

        room1 = roomService.getById(id);
        Assertions.assertEquals(room, room1);
    }

    @Test
    @DisplayName("Test for create room")
    public void createRoomTest() {
        RoomDTO room = new RoomDTO();
        Hotel hotel = new Hotel();
        hotel.setOwnerName("Franco");
        List<RoomReservation> roomReservationList = new ArrayList<>();
        RoomReservation roomReservation = new RoomReservation();
        roomReservationList.add(roomReservation);
        ServiceRoom serviceRoom = new ServiceRoom();
        List<ServiceRoom> serviceRooms = new ArrayList<>();
        room.setRoomReservations(roomReservationList);
        room.setImageLink("afaf");
        room.setAdultCapacity(5);
        room.setChildCapacity(5);
        room.setServiceRooms(serviceRooms);
        room.setType(0);
        room.setHotel(hotel);
        when(roomService.create(room)).thenReturn(new ResponseEntity(room, HttpStatus.CREATED));
        Assertions.assertEquals(room, room);
    }


    @Test
    @DisplayName("Test get by date")
    public void testByDateTest() throws Exception{
        ReservationResponseDTO reservationDTO = new ReservationResponseDTO();
        Reservation reservation = new Reservation();
        Date date = java.sql.Date.valueOf("2019-03-13");
        Date date2 = java.sql.Date.valueOf("2019-03-14");
        Room room = new Room();

        RoomReservation roomReservation = new RoomReservation();
        List<RoomReservation> roomReservations = new ArrayList<>();

        reservation.setInitialDate(date);
        reservation.setFinalDate(date2);
        roomReservation.setRoom(room);
        roomReservation.setReservation(reservation);
        roomReservations.add(roomReservation);
        roomReservation.setReservation(reservation);
        room.setRoomReservations(roomReservations);
        List<Room> rooms = new ArrayList<>();
        rooms.add(room);
        reservationDTO.setInitialDate(date);
        reservationDTO.setFinalDate(date2);
        reservationDTO.setRoomList(rooms);
        doReturn(Arrays.asList(room)).when(roomRepository).findAll();
        roomService.getByDate(reservationDTO);
        Assertions.assertEquals(reservationDTO, reservationDTO);

    }














































}
