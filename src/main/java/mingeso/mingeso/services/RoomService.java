package mingeso.mingeso.services;

import mingeso.mingeso.models.Room;
import mingeso.mingeso.repositories.RoomRepository;
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
        return new ResponseEntity(roomRepository.save(room), HttpStatus.CREATED);
    }
}