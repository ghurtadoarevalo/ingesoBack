package mingeso.mingeso.services;

import mingeso.mingeso.dto.ReservationDTO;
import mingeso.mingeso.models.Reservation;
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
    public ResponseEntity create(@RequestBody ReservationDTO reservationDTO) {
        Reservation newReservation = new Reservation();
        newReservation.setState(reservationDTO.getState());
        newReservation.setInitialDate(reservationDTO.getInitialDate());
        newReservation.setFinalDate(reservationDTO.getFinalDate());
        newReservation.setRoomList(reservationDTO.getRoomList());
        newReservation.setClient(reservationDTO.getClient());
        
        return new ResponseEntity(reservationRepository.save(newReservation), HttpStatus.CREATED);
    }

    @PostMapping(value = "/createFinal")
    @ResponseBody
    public ResponseEntity createFinal(@RequestBody ReservationDTO reservationDTO) {
        Reservation newReservation = new Reservation();

        //0: Antes del check-out
        newReservation.setState(0);

        //Setear [Inicio, Termino] a la nueva reserva.

        //Obtengo dia actual, en base a eso agrego state.

        newReservation.setRoomList(reservationDTO.getRoomList());
        newReservation.setClient(reservationDTO.getClient());

        //Verificar si cliente existe con pasaporte -- findByPassport

        //Obtener arreglo de dias.

        //Guardar dentro de la reserva.

        return new ResponseEntity(reservationRepository.save(newReservation), HttpStatus.CREATED);
    }

    @GetMapping(value = "/test")
    @ResponseBody
    public ResponseEntity information() {
        //Conformar JSON

        //[Reservas1, R]


        return new ResponseEntity(HttpStatus.CREATED);
    }



}
