package mingeso.mingeso.services;

import mingeso.mingeso.models.Room;
import mingeso.mingeso.models.ServiceRoom;
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
    public ResponseEntity getAll() {
        List<Room> rooms = roomRepository.findAll();
        return new ResponseEntity(rooms, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity getById(@PathVariable("id") Long id) {
        Room roomValue;
        Optional<Room> room = roomRepository.findById(id);
        if(room.isPresent()) {
            roomValue = room.get();
            return new ResponseEntity(roomValue, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity create(@RequestBody Room room) {

        Boolean verificator = true;

        if(room.getHotel() != null) {
            if(!hotelRepository.findById(room.getHotel().getHotelId()).isPresent()){
                verificator = false;
            }
        }else{verificator = false;}

        if(room.getReservation() != null) {
            if(!reservationRepository.findById(room.getReservation().getReservationId()).isPresent()){
                verificator = false;
            }
        }else{verificator = false;}

        if(room.getReservation() != null) {
            if(!reservationRepository.findById(room.getReservation().getReservationId()).isPresent()){
                verificator = false;
            }
        }else{verificator = false;}

        List<ServiceRoom> serviceRoomList = room.getServiceRooms();
        if(null != serviceRoomList){
            for(int i = 0 ; i < serviceRoomList.size();i++){
                ServiceRoom serviceRoom = serviceRoomList.get(i);
                if(!roomRepository.findById(serviceRoom.getRoom().getRoomId()).isPresent()){
                    verificator = false;
                    break;
                }
                if(!serviceRepository.findById(serviceRoom.getService().getServiceId()).isPresent()){
                    verificator = false;
                    break;
                }
            }
        }else{verificator = false;}

        if(!verificator){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else {
            Room newRoom = new Room();
            newRoom.setImageLink(room.getImageLink());
            newRoom.setType(room.getType());
            newRoom.setRoomNumber(room.getRoomNumber());
            newRoom.setPrice(room.getPrice());
            newRoom.setChildCapacity(room.getChildCapacity());
            newRoom.setAdultCapacity(room.getAdultCapacity());
            newRoom.setHotel(room.getHotel());
            newRoom.setReservation(room.getReservation());
            newRoom.setServiceRooms(room.getServiceRooms());
            return new ResponseEntity(roomRepository.save(newRoom), HttpStatus.CREATED);
        }
    }
}