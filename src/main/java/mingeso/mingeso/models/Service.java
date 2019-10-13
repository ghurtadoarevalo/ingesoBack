package mingeso.mingeso.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service",schema = "usach")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "service_id", unique = true, nullable = false)
    private Long serviceId;

    @Column(name = "type", nullable = false, length = 3)
    private int type;

    @Column(name = "price", nullable = false, length = 10)
    private int price;

    @Column(name = "service_name", nullable = false, length = 25)
    private String serviceName;

    @Column(name = "manager_name", nullable = false, length = 25)
    private String managerName;

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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public List<ServiceRoom> getServiceRooms() {
        return serviceRooms;
    }

    public void setServiceRooms(List<ServiceRoom> serviceRooms) {
        this.serviceRooms = serviceRooms;
    }
}
