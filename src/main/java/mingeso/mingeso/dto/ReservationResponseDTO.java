package mingeso.mingeso.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date initialDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date finalDate;

    @JsonFormat(pattern="MM/dd/yyyy")
    private Date originalFormatInitial;
    @JsonFormat(pattern="MM/dd/yyyy")
    private Date originalFormatFinal;

    private List<String> dateList;

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

    public List<String> getDateList() {
        return dateList;
    }

    public void setDateList(List<String> dateList) {
        this.dateList = dateList;
    }

    public Date getOriginalFormatInitial() {
        return originalFormatInitial;
    }

    public void setOriginalFormatInitial(Date originalFormatInitial) {
        this.originalFormatInitial = originalFormatInitial;
    }

    public Date getOriginalFormatFinal() {
        return originalFormatFinal;
    }

    public void setOriginalFormatFinal(Date originalFormatFinal) {
        this.originalFormatFinal = originalFormatFinal;
    }
}
