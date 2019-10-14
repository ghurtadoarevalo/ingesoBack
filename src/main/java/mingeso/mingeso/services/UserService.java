package mingeso.mingeso.services;

import mingeso.mingeso.dto.ClientDTO;
import mingeso.mingeso.dto.UserDTO;
import mingeso.mingeso.models.Client;
import mingeso.mingeso.models.Role;
import mingeso.mingeso.models.User;
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

    @GetMapping(value = "/users/{role_id}")
    @ResponseBody
    public ResponseEntity getUsersByRol(@PathVariable("role_id") long id) {
        List<User> users = userRepository.findAll();
        Optional<Role> role = roleRepository.findById(id);
        ArrayList<User> usersByRol = new ArrayList<>();
        if(role.isPresent()) {
            for(User us : users) {
                if(us.getRole() == role.get()) {
                    usersByRol.add(us);
                }
            }
        }  
        return new ResponseEntity(usersByRol, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity create(@RequestBody UserDTO userDTO) {
        User newUser = new User();
        newUser.setPassword(userDTO.getPassword());
        newUser.setName(userDTO.getName());
        newUser.setContact(userDTO.getContact());

        Optional<Role> role = roleRepository.findById(userDTO.getRole().getRoleId());
        if(role.isPresent()){
            newUser.setRole(userDTO.getRole());
            return new ResponseEntity(userRepository.save(newUser), HttpStatus.CREATED);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
