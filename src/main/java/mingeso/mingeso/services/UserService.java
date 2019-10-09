package mingeso.mingeso.services;

import mingeso.mingeso.models.Reservation;
import mingeso.mingeso.models.Role;
import mingeso.mingeso.models.User;
import mingeso.mingeso.repositories.ReservationRepository;
import mingeso.mingeso.repositories.RoleRepository;
import mingeso.mingeso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ReservationRepository reservationRepository;


    @GetMapping(value = "/users")
    @ResponseBody
    public ResponseEntity getAll() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity getById(@PathVariable ("id") Long id) {
        User userValue;
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            userValue = user.get();
            return new ResponseEntity(userValue, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity create(@RequestBody User user) {

        Boolean verificator = true;
        List<Reservation> reservationList = user.getReservationList();
        for(int i = 0 ; i < reservationList.size();i++) {
            if(null == reservationRepository.findById(reservationList.get(i).getReservationId())){
                verificator = false;
            }
        }
        if(user.getRole() != null){
            if(null == roleRepository.findById(user.getRole().getRoleId())){
                verificator = false;
            }
        }else{verificator = false;}

        if(verificator == false){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else {
            User newUser = new User();
            newUser.setName(user.getName());
            newUser.setContact(user.getContact());
            newUser.setMail(user.getMail());
            newUser.setHistory(user.getHistory());
            newUser.setPassport(user.getPassport());
            newUser.setPassword(user.getPassword());
            newUser.setReservationList(user.getReservationList());
            newUser.setRole(user.getRole());
            newUser.setRut(user.getRut());
            return new ResponseEntity(userRepository.save(newUser), HttpStatus.CREATED);
        }
    }

    @GetMapping(value = "/users/{role_id}")
    @ResponseBody
    public ResponseEntity getUsersByRol(@PathVariable("role_id") long id) {
        List<User> users = userRepository.findAll();
        Optional<Role> role = roleRepository.findById(id);
        ArrayList<User> usersByRol = new ArrayList<>();
        for(User us : users) {
            if(us.getRole() == role.get()) {
                usersByRol.add(us);
            }
        }
        return new ResponseEntity(usersByRol, HttpStatus.OK);
    }
}
