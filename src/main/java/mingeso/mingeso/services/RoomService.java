package mingeso.mingeso.services;

import mingeso.mingeso.dto.RoomDTO;
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