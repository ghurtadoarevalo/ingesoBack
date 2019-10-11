package mingeso.mingeso.services;

import mingeso.mingeso.dto.ReservationDTO;
import mingeso.mingeso.models.Client;
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
    public ResponseEntity create(@RequestBody ReservationDTO reservationDTO) {

        Reservation newReservation = new Reservation();

        if(reservationDTO.getClient() == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else{
        Client inputClient = clientRepository.findByPassport(reservationDTO.getClient().getPassport());
        if(inputClient == null){
            Client newClient = new Client();
            newClient.setMail(inputClient.getMail());
            newClient.setContact(inputClient.getContact());
            newClient.setName(inputClient.getName());
            newClient.setPassport(inputClient.getPassport());
            newClient.setHistory(inputClient.getHistory());
            newClient.setReservationList(inputClient.getReservationList());
            newReservation.setClient(newClient);
        }else{
            newReservation.setClient(inputClient);
        }

        newReservation.setState(reservationDTO.getState());
        newReservation.setInitialDate(reservationDTO.getInitialDate());
        newReservation.setFinalDate(reservationDTO.getFinalDate());

        List<Room> roomList = new ArrayList<>();

        for(int i = 0 ; i < reservationDTO.getRoomList().size();i++)
        {
            long id = reservationDTO.getRoomList().get(i).getRoomId();
            Room room = roomRepository.findByRoomId(id);
            room.setReservation(newReservation);
            roomList.add(room);
        }

        newReservation.setRoomList(roomList);

        return new ResponseEntity(reservationRepository.save(newReservation),HttpStatus.CREATED);
        }
    }

}
