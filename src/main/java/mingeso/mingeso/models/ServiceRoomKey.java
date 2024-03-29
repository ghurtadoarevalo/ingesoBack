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
}
