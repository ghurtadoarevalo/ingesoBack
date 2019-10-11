package mingeso.mingeso.services;


import com.github.javafaker.Faker;
import mingeso.mingeso.FakerSingleton;
import mingeso.mingeso.models.*;
import mingeso.mingeso.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/faker")
@CrossOrigin(origins = "*")
public class FakerService {

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    FakerSingleton fakerSingleton =  new FakerSingleton();;


    @GetMapping(value = "/poblateDatabase")
    @ResponseBody
    public void poblateDatabase(){
        createHotel();
        createRoles();
        createServices();
        createRooms();
        createClients();
        createUsers();
    }

    public void createRoles(){
        for(int i = 0 ; i < 2;i++) {
            Role newRole = new Role();
            newRole.setType(i);
            roleRepository.save(newRole);
        }
    }

    public void createUsers(){
        Faker faker = fakerSingleton.getFaker();
        for (int i = 0 ; i < 4; i++) {
            User newUser = new User();
            if(i == 0){newUser.setRole(roleRepository.findRoleByType(0));}
            else{newUser.setRole(roleRepository.findRoleByType(1));}
            newUser.setName(faker.name().fullName());
            newUser.setContact(faker.phoneNumber().phoneNumber());
            newUser.setPassword(faker.internet().password());
            userRepository.save(newUser);
        }
    }

    public void createHotel(){
        Faker faker = fakerSingleton.getFaker();
        Hotel hotel = new Hotel();
        hotel.setContact("56964933854");
        hotel.setImageLink(faker.internet().image());
        hotel.setLocation(faker.address().fullAddress());
        hotel.setName("Hotel La Mision");
        hotel.setOwnerName(faker.name().fullName());
        hotelRepository.save(hotel);
    }

    public void createServices(){
        Faker faker = fakerSingleton.getFaker();
        List<String> servicesNames = new ArrayList<>();
        servicesNames.add("Tenis");
        servicesNames.add("Autos");
        servicesNames.add("Masaje");
        servicesNames.add("Piscina");
        servicesNames.add("Sala de pool");

        List<Integer> servicesPrices = new ArrayList<>();
        servicesPrices.add(10000);
        servicesPrices.add(5000);
        servicesPrices.add(20000);
        servicesPrices.add(5000);
        servicesPrices.add(7500);

        for(int i = 0 ; i < servicesNames.size();i++) {
            Service newService = new Service();
            newService.setPrice(servicesPrices.get(i));
            newService.setType(i);
            newService.setServiceName(servicesNames.get(i));
            newService.setManagerName(faker.name().fullName());
            serviceRepository.save(newService);
        }
    }

    public void createRooms(){
        Faker faker = fakerSingleton.getFaker();
        Hotel hotel = hotelRepository.findAll().get(0);
        for(int i = 0; i < 8;i++){
            Room newRoom = new Room();
            newRoom.setAdultCapacity(faker.number().numberBetween(1,6));
            newRoom.setChildCapacity(faker.number().numberBetween(1,6));
            newRoom.setType(faker.number().numberBetween(0,3));
            int price = 0;
            if(newRoom.getType()==0){price = 20000;}
            if(newRoom.getType()==1){price = 45000;}
            if(newRoom.getType()==2){price = 100000;}
            newRoom.setPrice(price);
            newRoom.setRoomNumber(faker.number().numberBetween(100,999));
            newRoom.setImageLink(faker.internet().image());
            newRoom.setHotel(hotel);
            roomRepository.save(newRoom);
        }
    }

    public void createClients(){
        Faker faker = fakerSingleton.getFaker();
        for (int i = 0 ; i < 50; i++) {
            Client newClient = new Client();
            History newHistory = new History();
            newClient.setName(faker.name().fullName());
            newClient.setContact(faker.phoneNumber().phoneNumber());
            newClient.setMail(faker.internet().safeEmailAddress());
            newClient.setPassport(createPassport());
            newClient.setHistory(newHistory);
            clientRepository.save(newClient);
        }
    }

    public String createPassport(){
        Faker faker = fakerSingleton.getFaker();
        StringBuilder passport = new StringBuilder();
        passport.append(faker.name().fullName().substring(0,3).toUpperCase());
        for(int i = 0 ; i < 6;i++) {
            int digito = faker.number().numberBetween(0,9);
            passport.append(digito);
        }
        return passport.toString();
    }

}