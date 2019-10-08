package mingeso.mingeso.services;

import mingeso.mingeso.models.Reservation;
import mingeso.mingeso.repositories.ReservationRepository;
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

    @GetMapping(value = "/reservations")
    @ResponseBody
    public ResponseEntity getAll() {
        List<Reservation> reservations = reservationRepository.findAll();
        return new ResponseEntity(reservations, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    @ResponseBody
    public ResponseEntity create(@RequestBody Reservation reservation) {
        return new ResponseEntity(reservationRepository.save(reservation), HttpStatus.CREATED);
    }
}
