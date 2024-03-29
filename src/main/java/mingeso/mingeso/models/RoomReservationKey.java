package mingeso.mingeso.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RoomReservationKey implements Serializable {

    @Column(name = "room_id", unique = true, nullable = false)
    private Long roomId;

    @Column(name = "reservation_id", unique = true, nullable = false)
    private Long reservationId;
}
