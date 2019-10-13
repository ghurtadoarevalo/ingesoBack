package mingeso.mingeso.dto;

import mingeso.mingeso.models.Client;
import mingeso.mingeso.models.Room;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class ReservationResponseDTO implements Serializable {

    private Long reservationId;
    private int state;
    private Client client;
    private List<Room> roomList;
    private Date initialDate;
    private Date finalDate;
    private List<Date> dateList;

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

    public List<Date> getDateList() {
        return dateList;
    }

    public void setDateList(List<Date> dateList) {
        this.dateList = dateList;
    }
}
