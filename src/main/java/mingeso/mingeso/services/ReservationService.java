package mingeso.mingeso.services;

import mingeso.mingeso.dto.ReservationResponseDTO;
import mingeso.mingeso.models.Client;
import mingeso.mingeso.models.Reservation;
import mingeso.mingeso.models.Room;
import mingeso.mingeso.models.RoomReservation;
import mingeso.mingeso.repositories.ReservationRepository;
import mingeso.mingeso.repositories.RoomRepository;
import mingeso.mingeso.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
@RequestMapping(value = "/reservation")
@CrossOrigin(origins = "*")
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ClientRepository clientRepository;

    @GetMapping(value = "/reservations")
    @ResponseBody
    public List<Reservation> getAll() {
         return reservationRepository.findAll();
    }

    @GetMapping(value = "/reservationsDates")
    @ResponseBody
    public List<ReservationResponseDTO> getReservationDates() {
        List<ReservationResponseDTO> reservationResponseDTOS = new ArrayList<>();
        List<Reservation> reservationList = reservationRepository.findAll();
        for(int i = 0 ; i < reservationList.size();i++) {
            ReservationResponseDTO reservationResponseDTO = new ReservationResponseDTO();
            List<Room> roomList = new ArrayList<>();
            Reservation reservation = reservationList.get(i);
            reservationResponseDTO.setInitialDate(reservation.getInitialDate());
            reservationResponseDTO.setFinalDate(reservation.getFinalDate());
            List<RoomReservation> roomReservations = reservation.getRoomReservations();
            for(int j = 0 ; j < roomReservations.size();j++){
                RoomReservation roomReservation = roomReservations.get(j);
                roomList.add(roomReservation.getRoom());
            }
            List<String> dates = getDatesInRange(reservation.getInitialDate(),reservation.getFinalDate());

            reservationResponseDTO.setRoomList(roomList);
            reservationResponseDTO.setDateList(dates);
            reservationResponseDTO.setClient(reservation.getClient());
            reservationResponseDTO.setState(reservation.getState());
            reservationResponseDTOS.add(reservationResponseDTO);
        }

        return reservationResponseDTOS;
    }


    @PostMapping(value = "/create")
    @ResponseBody
    public ResponseEntity create(@RequestBody ReservationResponseDTO reservationResponse) {

        Reservation newReservation = new Reservation();
        newReservation.setInitialDate(reservationResponse.getInitialDate());
        newReservation.setFinalDate(reservationResponse.getFinalDate());

        if(reservationResponse.getClient() == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else{
        Client inputClient = clientRepository.findByPassport(reservationResponse.getClient().getPassport());
        if(inputClient == null){
            Client newClient = new Client();
            newClient.setMail(reservationResponse.getClient().getMail());
            newClient.setContact(reservationResponse.getClient().getContact());
            newClient.setName(reservationResponse.getClient().getName());
            newClient.setPassport(reservationResponse.getClient().getPassport());
            newReservation.setClient(newClient);

        }else{
            newReservation.setClient(inputClient);
        }

        List<Room> roomList = reservationResponse.getRoomList();
        List<RoomReservation> roomReservations = new ArrayList<>();
        for(int i = 0 ; i < roomList.size();i++)
        {
            RoomReservation roomReservation = new RoomReservation();
            long id = roomList.get(i).getRoomId();
            Room room = roomRepository.findByRoomId(id);
            roomReservation.setRoom(room);
            roomReservation.setReservation(newReservation);
            roomReservations.add(roomReservation);
        }
        newReservation.setRoomReservations(roomReservations);
        return new ResponseEntity(reservationRepository.save(newReservation),HttpStatus.CREATED);
        }
    }

    public List<String> getDatesInRange(Date initialDate, Date finalDate){
        List<String> dates = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        Calendar endCalendar = new GregorianCalendar();
        calendar.setTime(initialDate);
        endCalendar.setTime(finalDate);
        while (calendar.before(endCalendar)) {
            java.util.Date result = calendar.getTime();
            Date sqlDate = new Date(result.getTime());
            dates.add(changeDateFormat(sqlDate));
            calendar.add(Calendar.DATE, 1);
        }
        dates.add(changeDateFormat(finalDate));
        return dates;
    }

    public String changeDateFormat(java.sql.Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

}
