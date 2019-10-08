package mingeso.mingeso.services;


import com.github.javafaker.Faker;
import mingeso.mingeso.models.User;
import mingeso.mingeso.repositories.HistoryRepository;
import mingeso.mingeso.repositories.RoomRepository;
import mingeso.mingeso.repositories.ServiceRepository;
import mingeso.mingeso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;


@Controller
@RequestMapping(value = "/faker")
@CrossOrigin(origins = "*")
public class FakerService {
    @Autowired
    Faker faker;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    UserRepository userRepository;


    @GetMapping(value = "/users")
    @ResponseBody
    public void createUsers(){
        for (int i = 0 ; i < 50; i++)
        {
            User newUser = new User();
            newUser.setName(faker.name().fullName());
            newUser.setPassword(faker.internet().password());
            newUser.setRut(createRut());
            newUser.setContact(faker.phoneNumber().phoneNumber());
            newUser.setMail(faker.internet().safeEmailAddress());


        }
    }

    @GetMapping(value = "/test")
    @ResponseBody
    public String createRut(){
        String rut = "";
        for(int i = 0; i<7;i++) {
            int digito = (int)Math.round(Math.random()*9);
            rut = rut + digito;
        }
        int verificador = (int)Math.round(Math.random()*9);
        return rut + "-" + verificador;
    }

    public String createPassport(){
        String passport = "";

        return passport;
    }

}
