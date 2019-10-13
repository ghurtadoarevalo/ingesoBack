package mingeso.mingeso.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "reservation",schema = "usach")
public class Reservation {

    @Id
    @Column(name = "reservation_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long reservationId;

    @Column(name = "state", nullable = false, length = 2)
    private int state;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id", nullable=false)
    private Client client;

    @Column(name = "initial_date", nullable = false, length = 15)
    private Date initialDate;

    @Column(name = "final_date", nullable = false, length = 15)
    private Date finalDate;

    @JsonIgnore
    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<RoomReservation> roomReservations;


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

    public List<RoomReservation> getRoomReservations() {
        return roomReservations;
    }

    public void setRoomReservations(List<RoomReservation> roomReservations) {
        this.roomReservations = roomReservations;
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

    public Reservation(int state, Client client, Date initialDate, Date finalDate) {
        this.state = state;
        this.client = client;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
    }
}
