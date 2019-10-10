package mingeso.mingeso.dto;

import mingeso.mingeso.models.Client;
import mingeso.mingeso.models.Room;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class ReservationDTO implements Serializable {

    private Long reservationId;
    private Date initialDate;
    private Date finalDate;
    private int estate;
    private Client client;
    private List<Room> roomList;

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
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
}
