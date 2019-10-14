package mingeso.mingeso.services;

import mingeso.mingeso.dto.ReservationResponseDTO;
import mingeso.mingeso.dto.RoomDTO;
import mingeso.mingeso.models.Reservation;
import mingeso.mingeso.models.Room;
import mingeso.mingeso.models.RoomReservation;
import mingeso.mingeso.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/room")
@CrossOrigin(origins = "*")
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;


    @GetMapping(value = "/rooms")
    @ResponseBody
    public List<Room> getAll() {
        return roomRepository.findAll();
    }


    @PostMapping(value = "/getByDate")
    @ResponseBody
    public ReservationResponseDTO getByDate(@RequestBody ReservationResponseDTO reservationDTO) {

        Date initialDate = reservationDTO.getOriginalFormatInitial();
        if(initialDate == null){ initialDate = reservationDTO.getInitialDate(); }

        Date finalDate = reservationDTO.getOriginalFormatFinal();
        if(finalDate == null){ finalDate = reservationDTO.getFinalDate(); }

        List<Room> roomList = roomRepository.findAll();
        List<Room> roomListResponse = new ArrayList<>();

        for(int i = 0 ; i < roomList.size();i++)
        {
            boolean validator = false;

            List<RoomReservation> roomReservations = roomList.get(i).getRoomReservations();
            if(roomReservations != null){
                if(roomReservations.size()==0){
                    validator = true;
                }else {
                    for (int j = 0; j < roomReservations.size(); j++) {
                        Reservation reservation = roomReservations.get(j).getReservation();
                        if (reservation == null) {
                            validator = true;
                            break;
                        } else {

                            Date roomInitialDate = reservation.getInitialDate();
                            Date roomFinalDate = reservation.getFinalDate();
                            if (roomInitialDate.toString().equals("") || roomFinalDate.toString().equals("")) {
                                validator = true;
                            } else {
                                if(initialDate.toString().equals(roomInitialDate.toString())){
                                    validator = false;
                                    break;
                                }
                                if(finalDate.toString().equals(roomFinalDate.toString())){
                                    validator = false;
                                    break;
                                }
                                if(initialDate.toString().equals(roomFinalDate.toString())){
                                    validator = false;
                                    break;
                                }
                                if(finalDate.compareTo(roomInitialDate) < 0){
                                    validator = true;
                                }
                                else{
                                    if(initialDate.compareTo(roomFinalDate) > 0){
                                        validator = true;
                                    }else{
                                        validator = false;
                                        break;
                                    }
                                }
                                if(!validator){
                                    if(initialDate.compareTo(roomFinalDate) > 0){
                                        validator = true;
                                    }
                                    else{
                                        if(initialDate.compareTo(roomInitialDate) < 0){
                                            validator = true;
                                        }else{
                                            validator = false;
                                        }
                                    }
                                }
                                if(!validator){
                                    break;
                                }
                            }
                        }
                    }
                }
                if(validator){
                    roomListResponse.add(roomList.get(i));
                }
            }
        }
        ReservationResponseDTO reservationOutput = new ReservationResponseDTO();
        reservationOutput.setInitialDate(initialDate);
        reservationOutput.setFinalDate(finalDate);
        reservationOutput.setRoomList(roomListResponse);
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
        newRoom.setServiceRooms(roomDTO.getServiceRooms());
        newRoom.setServiceRooms(roomDTO.getServiceRooms());
        return new ResponseEntity(roomRepository.save(newRoom), HttpStatus.CREATED);
    }

}