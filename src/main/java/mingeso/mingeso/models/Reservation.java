package mingeso.mingeso.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "reservation",schema = "usach")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "reservation_id", unique = true, nullable = false)
    private Long reservationId;

    @Column(name = "estate", nullable = false, length = 2)
    private int estate;

    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client client;

    @OneToMany(mappedBy="reservation")
    private List<Room> roomList;

    @OneToMany(mappedBy="reservation")
    private List<Day> dateList;


    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }


    public int getEstate() {
        return estate;
    }

    public void setEstate(int estate) {
        this.estate = estate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Day> getDates() {
        return dateList;
    }

    public void setDates(List<Day> dates) {
        this.dateList = dates;
    }

    public void addDay(Day day) {
        this.dateList.add(day);
    }

    public Reservation() {

    }

    public Reservation(int estate, Client client, List<Room> roomList, List<Day> dateList) {
        this.estate = estate;
        this.client = client;
        this.roomList = roomList;
        this.dateList = dateList;
    }
}
