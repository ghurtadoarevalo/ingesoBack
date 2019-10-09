package mingeso.mingeso.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "reservation",schema = "usach")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "reservation_id", unique = true, nullable = false)
    private Long reservationId;

    @Column(name = "initial_date", nullable = false, length = 50)
    private Date initialDate;

    @Column(name = "final_date", nullable = false, length = 50)
    private Date finalDate;

    @Column(name = "estate", nullable = false, length = 2)
    private int estate;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @OneToMany(mappedBy="reservation")
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
}
