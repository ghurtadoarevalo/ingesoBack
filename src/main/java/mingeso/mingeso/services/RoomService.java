package mingeso.mingeso.services;

import mingeso.mingeso.dto.ReservationDTO;
import mingeso.mingeso.dto.RoomDTO;
import mingeso.mingeso.models.Reservation;
import mingeso.mingeso.models.Room;
import mingeso.mingeso.repositories.HotelRepository;
import mingeso.mingeso.repositories.ReservationRepository;
import mingeso.mingeso.repositories.RoomRepository;
import mingeso.mingeso.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/room")
@CrossOrigin(origins = "*")
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping(value = "/rooms")
    @ResponseBody
    public List<Room> getAll() {
        return roomRepository.findAll();
    }


    @GetMapping(value = "/getByDate")
    @ResponseBody
    public ReservationDTO getByDate(@RequestBody ReservationDTO reservationDTO) {

        Date initialDate = reservationDTO.getInitialDate();
        Date finalDate = reservationDTO.getFinalDate();

        List<Room> roomList = roomRepository.findAll();

        for(int i = 0 ; i < roomList.size();i++)
        {
            boolean validator = false;
            Reservation reservation = roomList.get(i).getReservation();
            if(reservation == null){
                validator = true;
            }else {

                Date roomInitialDate = reservation.getInitialDate();
                Date roomFinalDate = reservation.getFinalDate();

                if (roomInitialDate.toString() == "" || roomFinalDate.toString() == "") {
                    validator = true;
                } else {
                    if (initialDate.compareTo(roomInitialDate) < 0) {
                        if (finalDate.compareTo(roomInitialDate) < 0) {
                            validator = true;
                        }
                    } else {
                        if (initialDate.compareTo(roomFinalDate) > 0) {
                            validator = true;
                        }
                    }
                }
            }
            if(validator == false){
                roomList.remove(roomList.get(i));
            }
        }

        ReservationDTO reservationOutput = new ReservationDTO();
        reservationOutput.setInitialDate(initialDate);
        reservationOutput.setFinalDate(finalDate);
        reservationOutput.setRoomList(roomList);

        return reservationOutput;
    }



    @GetMapping(value = "/{id}")
    @ResponseBody
    public Room getById(@PathVariable("id") Long id) {
        Optional<Room> room = roomRepository.findById(id);
        if(room.isPresent()) {
            return room.get();
        }
        return null;
    }

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity create(@RequestBody RoomDTO roomDTO) {
        Room newRoom = new Room();
        newRoom.setImageLink(roomDTO.getImageLink());
        newRoom.setType(roomDTO.getType());
        newRoom.setRoomNumber(roomDTO.getRoomNumber());
        newRoom.setPrice(roomDTO.getPrice());
        newRoom.setChildCapacity(roomDTO.getChildCapacity());
        newRoom.setAdultCapacity(roomDTO.getAdultCapacity());
        newRoom.setHotel(roomDTO.getHotel());
        newRoom.setReservation(roomDTO.getReservation());
        newRoom.setServiceRooms(roomDTO.getServiceRooms());
        return new ResponseEntity(roomRepository.save(newRoom), HttpStatus.CREATED);
    }
}