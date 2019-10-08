package mingeso.mingeso.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room",schema = "usach")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "room_id", unique = true, nullable = false)
    private Long roomId;

    //0: Tipo 0
    //1: Tipo 1
    //2: Tipo 2 ...
    @Column(name = "type", nullable = false, length = 3)
    private int type;

    @Column(name = "price", nullable = false, length = 10)
    private int price;

    @Column(name = "room_number", nullable = false, length = 5)
    private int roomNumber;

    @Column(name = "child_capacity", nullable = false, length = 3)
    private int childCapacity;

    @Column(name = "adult_capacity", nullable = false, length = 3)
    private int adultCapacity;


    @Column(name = "image_link", nullable = false, length = 50)
    private String imageLink;


    @ManyToOne
    @JoinColumn(name="reservation_id", nullable=false)
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name="hotel_id", nullable=false)
    private Hotel hotel;

    @JsonIgnore
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<ServiceRoom> serviceRooms;


    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getChildCapacity() {
        return childCapacity;
    }

    public void setChildCapacity(int childCapacity) {
        this.childCapacity = childCapacity;
    }

    public int getAdultCapacity() {
        return adultCapacity;
    }

    public void setAdultCapacity(int adultCapacity) {
        this.adultCapacity = adultCapacity;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
