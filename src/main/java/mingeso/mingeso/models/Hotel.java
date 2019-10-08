package mingeso.mingeso.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hotel",schema = "usach")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "hotel_id", unique = true, nullable = false)
    private Long hotelId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "contact", nullable = false, length = 50)
    private int contact;

    @Column(name = "location", nullable = false, length = 100)
    private String location;

    @Column(name = "owner_name", nullable = false, length = 50)
    private String ownerName;

    @Column(name = "image_link", nullable = false, length = 50)
    private String imageLink;

    @OneToMany(mappedBy="hotel")
    private List<Room> roomList;


    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
