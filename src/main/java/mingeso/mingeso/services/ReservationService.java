package mingeso.mingeso.services;

import mingeso.mingeso.models.Reservation;
import mingeso.mingeso.models.Room;
import mingeso.mingeso.repositories.ReservationRepository;
import mingeso.mingeso.repositories.RoomRepository;
import mingeso.mingeso.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity create(@RequestBody Reservation reservation) {
        Reservation newReservation = new Reservation();
        newReservation.setEstate(reservation.getEstate());
        newReservation.setFinalDate(reservation.getFinalDate());
        newReservation.setInitialDate(reservation.getInitialDate());
        newReservation.setRoomList(reservation.getRoomList());
        newReservation.setClient(reservation.getClient());
        return new ResponseEntity(reservationRepository.save(newReservation), HttpStatus.CREATED);
    }
}
