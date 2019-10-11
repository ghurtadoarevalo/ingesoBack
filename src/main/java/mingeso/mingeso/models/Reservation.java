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

    @Column(name = "state", nullable = false, length = 2)
    private int state;

    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client client;

    @OneToMany(mappedBy="reservation")
    private List<Room> roomList;

    @Column(name = "initial_date", nullable = false, length = 15)
    private Date initialDate;

    @Column(name = "final_date", nullable = false, length = 15)
    private Date finalDate;


    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public Reservation() {

    }


    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public Reservation(int state, Client client, List<Room> roomList, Date initialDate, Date finalDate) {
        this.state = state;
        this.client = client;
        this.roomList = roomList;
        this.initialDate = initialDate;
        this.finalDate = initialDate;
    }
}
