package mingeso.mingeso.services;


import com.github.javafaker.Faker;
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
    Faker faker;

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    RoleRepository roleRepository;


    @GetMapping(value = "/poblateDatabase")
    @ResponseBody
    public void poblateDatabase(){
        createHotel();
        createRoles();
        createServices();
        createRooms();
        createUsers();
        addUserRole();
    }

    public void createRoles(){
        for(int i = 0 ; i < 3;i++) {
            Role newRole = new Role();
            newRole.setType(i);
            roleRepository.save(newRole);
        }
    }

    public void createHotel(){
        Hotel hotel = new Hotel();
        hotel.setContact("56964933854");
        hotel.setImageLink(faker.internet().image());
        hotel.setLocation(faker.address().fullAddress());
        hotel.setName("Hotel La Mision");
        hotel.setOwnerName(faker.name().fullName());
        hotelRepository.save(hotel);
    }

    public void createServices(){

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
        Hotel hotel = hotelRepository.findAll().get(0);
        for(int i = 0; i < 8;i++){
            Room newRoom = new Room();
            newRoom.setAdultCapacity(faker.number().numberBetween(1,6));
            newRoom.setChildCapacity(faker.number().numberBetween(1,6));
            newRoom.setType(faker.number().numberBetween(0,2));
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

    public void createUsers(){
        for (int i = 0 ; i < 50; i++) {
            User newUser = new User();
            History newHistory = new History();
            newUser.setName(faker.name().fullName());
            newUser.setPassword(faker.internet().password());
            newUser.setRut(createRut());
            newUser.setContact(faker.phoneNumber().phoneNumber());
            newUser.setMail(faker.internet().safeEmailAddress());
            newUser.setPassport(createPassport());
            newUser.setHistory(newHistory);
            userRepository.save(newUser);
        }
    }

    public void addUserRole(){
        List<User> userList = userRepository.findAll();

        Role generalUser = roleRepository.findRoleByType(0);
        Role receptionist = roleRepository.findRoleByType(1);
        Role admin = roleRepository.findRoleByType(2);

        userList.get(0).setRole(admin);
        userList.get(1).setRole(receptionist);
        userList.get(2).setRole(receptionist);
        userList.get(3).setRole(receptionist);

        for(int i = 4 ; i < userList.size();i++) {
            userList.get(i).setRole(generalUser);
        }
        for(int i = 0 ; i < userList.size();i++){
            userRepository.save(userList.get(i));
        }
    }


    public String createRut(){
        String rut = "";
        int inicio = faker.number().numberBetween(0,1);
        if(inicio == 1){rut = rut+inicio;}

        rut = rut + faker.number().numberBetween(1,9);

        for(int i = 0; i<6;i++) {
            int digito = faker.number().numberBetween(0,9);
            rut = rut + digito;
        }
        int verificador = faker.number().numberBetween(0,11);
        if(verificador == 10){rut = rut + "-k";}
        else{rut = rut + "-" + verificador;}
        return rut;
    }

    public String createPassport(){
        String passport = "";
        passport = faker.name().fullName().substring(0,3).toUpperCase();
        for(int i = 0 ; i < 6;i++) {
            int digito = faker.number().numberBetween(0,9);
            passport = passport + digito;
        }
        return passport;
    }

}