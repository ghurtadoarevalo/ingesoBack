package mingeso.mingeso.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "room_reservation",schema = "usach")
@Data
public class RoomReservation {

    @EmbeddedId
    private RoomReservationKey srId = new RoomReservationKey();

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("roomId")
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("reservationId")
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
