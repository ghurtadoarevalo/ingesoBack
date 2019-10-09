package mingeso.mingeso.services;

import mingeso.mingeso.models.Client;
import mingeso.mingeso.models.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {




    @GetMapping(value = "/users/{role_id}")
    @ResponseBody
    public ResponseEntity getUsersByRol(@PathVariable("role_id") long id) {
        List<Client> clients = userRepository.findAll();
        Optional<Role> role = roleRepository.findById(id);
        ArrayList<Client> usersByRol = new ArrayList<>();
        for(Client us : users) {
            if(us.getRole() == role.get()) {
                usersByRol.add(us);
            }
        }
        return new ResponseEntity(usersByRol, HttpStatus.OK);
    }


}
