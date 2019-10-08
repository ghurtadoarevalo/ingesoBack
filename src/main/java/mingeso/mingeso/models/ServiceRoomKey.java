package mingeso.mingeso.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class ServiceRoomKey implements Serializable {

    @Column(name = "service_id", unique = true, nullable = false)
    private Long serviceId;

    @Column(name = "room_id", unique = true, nullable = false)
    private Long roomId;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}
