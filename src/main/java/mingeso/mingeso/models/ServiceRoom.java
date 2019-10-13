package mingeso.mingeso.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "service_room",schema = "usach")
public class ServiceRoom {

    @EmbeddedId
    private ServiceRoomKey srId = new ServiceRoomKey();

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("serviceId")
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("roomId")
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "date", nullable = false, length = 50)
    private Date date;

    public ServiceRoomKey getSrId() {
        return srId;
    }

    public void setSrId(ServiceRoomKey srId) {
        this.srId = srId;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
