package mingeso.mingeso.services;

import mingeso.mingeso.dto.ClientDTO;
import mingeso.mingeso.models.Client;
import mingeso.mingeso.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/client")
@CrossOrigin(origins = "*")
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(value = "/clients")
    @ResponseBody
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Client getById(@PathVariable ("id") Long id) {
        Client userValue;
        Optional<Client> user = clientRepository.findById(id);
        if(user.isPresent()) {
            userValue = user.get();
            return userValue;
        } else {
            return null;
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity create(@RequestBody ClientDTO client) {
        Client newClient = new Client();
        newClient.setName(client.getName());
        newClient.setContact(client.getContact());
        newClient.setMail(client.getMail());
        newClient.setHistory(client.getHistory());
        newClient.setPassport(client.getPassport());
        newClient.setReservationList(client.getReservationList());
        return new ResponseEntity(clientRepository.save(newClient), HttpStatus.CREATED);
    }
}
