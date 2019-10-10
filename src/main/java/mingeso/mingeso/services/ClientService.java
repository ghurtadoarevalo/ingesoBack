package mingeso.mingeso.services;

import mingeso.mingeso.models.Reservation;
import mingeso.mingeso.models.Client;
import mingeso.mingeso.repositories.ReservationRepository;
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

    @Autowired
    private ReservationRepository reservationRepository;


    @GetMapping(value = "/clients")
    @ResponseBody
    public ResponseEntity getAll() {
        List<Client> users = clientRepository.findAll();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity getById(@PathVariable ("id") Long id) {
        Client userValue;
        Optional<Client> user = clientRepository.findById(id);
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
    public ResponseEntity create(@RequestBody Client user) {

        Boolean verificator = true;
        List<Reservation> reservationList = user.getReservationList();
        for(int i = 0 ; i < reservationList.size();i++) {
            if(!reservationRepository.findById(reservationList.get(i).getReservationId()).isPresent()){
                verificator = false;
            }
        }
        if(!verificator){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else {
            Client newClient = new Client();
            newClient.setName(user.getName());
            newClient.setContact(user.getContact());
            newClient.setMail(user.getMail());
            newClient.setHistory(user.getHistory());
            newClient.setPassport(user.getPassport());
            newClient.setReservationList(user.getReservationList());
            newClient.setRut(user.getRut());
            return new ResponseEntity(clientRepository.save(newClient), HttpStatus.CREATED);
        }
    }
}
