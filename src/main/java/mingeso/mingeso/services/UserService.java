package mingeso.mingeso.services;

import mingeso.mingeso.models.User;
import mingeso.mingeso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*")
public class UserService {

    @Autowired
    private UserRepository userRepository;

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
        return new ResponseEntity(userRepository.save(user), HttpStatus.CREATED);
    }
}
