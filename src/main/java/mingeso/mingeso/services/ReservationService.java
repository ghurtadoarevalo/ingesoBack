package mingeso.mingeso.services;

import mingeso.mingeso.dto.ReservationResponseDTO;
import mingeso.mingeso.models.Client;
import mingeso.mingeso.models.Reservation;
import mingeso.mingeso.models.Room;
import mingeso.mingeso.models.RoomReservation;
import mingeso.mingeso.repositories.ReservationRepository;
import mingeso.mingeso.repositories.RoomRepository;
import mingeso.mingeso.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/reservation")
@CrossOrigin(origins = "*")
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ClientRepository clientRepository;

    @GetMapping(value = "/reservations")
    @ResponseBody
    public List<Reservation> getAll() {
         return reservationRepository.findAll();
    }


    @PostMapping(value = "/create")
    @ResponseBody
    public ResponseEntity create(@RequestBody ReservationResponseDTO reservationResponse) {

        Reservation newReservation = new Reservation();
        //List<Reservation> reservations = new ArrayList<>();

        newReservation.setInitialDate(reservationResponse.getInitialDate());
        newReservation.setFinalDate(reservationResponse.getFinalDate());

        if(reservationResponse.getClient() == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else{
        Client inputClient = clientRepository.findByPassport(reservationResponse.getClient().getPassport());
        if(inputClient == null){
            Client newClient = new Client();
            newClient.setMail(reservationResponse.getClient().getMail());
            newClient.setContact(reservationResponse.getClient().getContact());
            newClient.setName(reservationResponse.getClient().getName());
            newClient.setPassport(reservationResponse.getClient().getPassport());
            //reservations.add(newReservation);
            newReservation.setClient(newClient);

        }else{
            newReservation.setClient(inputClient);
        }

        List<Room> roomList = reservationResponse.getRoomList();
        List<RoomReservation> roomReservations = new ArrayList<>();

        System.out.println(newReservation.getReservationId());
        for(int i = 0 ; i < roomList.size();i++)
        {
            RoomReservation roomReservation = new RoomReservation();

            long id = roomList.get(i).getRoomId();
            Room room = roomRepository.findByRoomId(id);

            roomReservation.setRoom(room);
            roomReservation.setReservation(newReservation);

            roomReservations.add(roomReservation);
        }

        newReservation.setRoomReservations(roomReservations);

        return new ResponseEntity(reservationRepository.save(newReservation),HttpStatus.CREATED);
        }
    }

}
