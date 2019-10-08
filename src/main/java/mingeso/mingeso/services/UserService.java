package mingeso.mingeso.services;

import mingeso.mingeso.models.User;
import mingeso.mingeso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity create(@RequestBody User user) {
        return new ResponseEntity(userRepository.save(user), HttpStatus.CREATED);
    }
}
