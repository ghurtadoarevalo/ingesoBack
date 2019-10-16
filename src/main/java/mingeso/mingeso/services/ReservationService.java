package mingeso.mingeso.services;

import mingeso.mingeso.dto.ReservationResponseDTO;
import mingeso.mingeso.models.Client;
import mingeso.mingeso.models.Reservation;
import mingeso.mingeso.models.Room;
import mingeso.mingeso.models.RoomReservation;
import mingeso.mingeso.repositories.ReservationRepository;
import mingeso.mingeso.repositories.RoomRepository;
import mingeso.mingeso.repositories.ClientRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @GetMapping(value = "/getInitialAndFinal")
    @ResponseBody
    public String getInitialAndFinal(){
        JSONObject jsonObject = new JSONObject();
        List<Reservation> reservationList = reservationRepository.findAll();
        Date initialDate = reservationList.get(0).getInitialDate();
        Date finalDate = reservationList.get(0).getFinalDate();

        for(int i = 0 ; i < reservationList.size();i++){
            Date initialReservation = reservationList.get(i).getInitialDate();
            Date finalReservation = reservationList.get(i).getFinalDate();

            if(initialDate.compareTo(initialReservation) > 0){
                initialDate = initialReservation;
            }
            if(finalDate.compareTo(finalReservation) < 0){
                finalDate = finalReservation;
            }
        }
        jsonObject.put("initialDate",changeDateFormat(initialDate));
        jsonObject.put("finalDate",changeDateFormat(finalDate));

        return jsonObject.toString();
    }


    @GetMapping(value = "/getAllWithDate")
    @ResponseBody
    public String getWithFormat(){

        JSONObject jsonObject = new JSONObject();
        List<Room> roomList = roomRepository.findAll();

        Comparator<Room> compareByNumber =  (r1, r2) -> {
                Double r2RoomNumber = (double)r2.getRoomNumber();
                Double r1RoomNumber = (double)r1.getRoomNumber();
                return r2RoomNumber.compareTo(r1RoomNumber);
        };

        JSONArray roomsArray = new JSONArray();

        Collections.sort(roomList,compareByNumber);

        for(int i = roomList.size()-1 ; i > -1;i--){
            Room room = roomList.get(i);
            List<RoomReservation> roomReservations = room.getRoomReservations();
            Date date1 = java.sql.Date.valueOf("2019-03-13");

            JSONObject roomListItem = new JSONObject();
            roomListItem.put("TaskID",room.getRoomNumber());
            roomListItem.put("TaskName","Room");
            roomListItem.put("StartDate",changeDateFormat(date1));

            JSONArray roomsDatesReservationArray = new JSONArray();

            for(int j = 0 ; j < roomReservations.size();j++){
                Reservation reservation = roomReservations.get(j).getReservation();
                List<Date> dates = getDatesInRange(reservation.getInitialDate(),reservation.getFinalDate());
                Client client = reservation.getClient();
                for(int k = 0 ; k < dates.size();k++){
                    Date date = dates.get(k);
                    JSONObject roomsDatesReservationItem = new JSONObject();
                    roomsDatesReservationItem.put("date",changeDateFormat(date));
                    roomsDatesReservationItem.put("iconClass","Reservado");
                    roomsDatesReservationItem.put("tooltip","Reservado por: "+client.getName());
                    roomsDatesReservationItem.put("name","<span style='color:red; margin-left:10px'> R </span>");
                    roomsDatesReservationArray.put(roomsDatesReservationItem);
                }
            }
            roomListItem.put("Indicators",roomsDatesReservationArray);
            roomsArray.put(roomListItem);
        }
        
        jsonObject.put("reservations",roomsArray);
        return jsonObject.toString();
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
            List<Date> dates = getDatesInRange(reservation.getInitialDate(),reservation.getFinalDate());
            List<String> finalDates = new ArrayList<>();
            for(int j = 0; j < dates.size();j++){
                finalDates.add(changeDateFormat(dates.get(j)));
            }
            reservationResponseDTO.setReservationId(reservation.getReservationId());
            reservationResponseDTO.setRoomList(roomList);
            reservationResponseDTO.setDateList(finalDates);
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

    public List<Date> getDatesInRange(Date initialDate, Date finalDate){
        List<Date> dates = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        Calendar endCalendar = new GregorianCalendar();
        calendar.setTime(initialDate);
        endCalendar.setTime(finalDate);
        while (calendar.before(endCalendar)) {
            java.util.Date result = calendar.getTime();
            Date sqlDate = new Date(result.getTime());
            dates.add(sqlDate);
            calendar.add(Calendar.DATE, 1);
        }
        dates.add(finalDate);
        return dates;
    }

    public String changeDateFormat(java.sql.Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(date);
    }

}
