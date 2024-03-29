package mingeso.mingeso.dto;

import mingeso.mingeso.models.Client;
import mingeso.mingeso.models.Room;
import mingeso.mingeso.models.RoomReservation;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class ReservationDTO implements Serializable {

    private Long reservationId;

    private int state;
    private Client client;
    private List<RoomReservation> roomReservations;
    private Date initialDate;
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

    public List<RoomReservation> getRoomReservations() {
        return roomReservations;
    }

    public void setRoomReservations(List<RoomReservation> roomReservations) {
        this.roomReservations = roomReservations;
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
}
