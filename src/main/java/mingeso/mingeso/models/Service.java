package mingeso.mingeso.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "service",schema = "usach")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "service_id", unique = true, nullable = false)
    private Long serviceId;

    //0: Service 0
    //1: Service 1
    //2: Service 2
    @Column(name = "type", nullable = false, length = 3)
    private int type;

    @Column(name = "price", nullable = false, length = 10)
    private int price;

    @JsonIgnore
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private List<ServiceRoom> serviceRooms;



    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
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

}
