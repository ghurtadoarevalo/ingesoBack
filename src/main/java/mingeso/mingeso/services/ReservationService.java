package mingeso.mingeso.services;

import mingeso.mingeso.models.Reservation;
import mingeso.mingeso.models.Room;
import mingeso.mingeso.models.Client;
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
    public ResponseEntity getAll() {
        List<Reservation> reservations = reservationRepository.findAll();
        return new ResponseEntity(reservations, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    @ResponseBody
    public ResponseEntity create(@RequestBody Reservation reservation) {

        List<Room> inputRoomList = reservation.getRoomList();
        Boolean verification = true;

        for(int i = 0; i < inputRoomList.size();i++) {
            if(null==roomRepository.findById(inputRoomList.get(i).getRoomId())){
                verification = false;
                break;
            }
        }
        if(null == clientRepository.findById(reservation.getClient().getClientId())){
            verification = false;
        }

        if(!verification) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            Reservation newReservation = new Reservation();
            newReservation.setEstate(reservation.getEstate());
            newReservation.setFinalDate(reservation.getFinalDate());
            newReservation.setInitialDate(reservation.getInitialDate());
            newReservation.setRoomList(reservation.getRoomList());
            newReservation.setClient(reservation.getClient());
            return new ResponseEntity(reservationRepository.save(newReservation), HttpStatus.CREATED);
        }
    }
}
