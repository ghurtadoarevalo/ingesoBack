package mingeso.mingeso.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mingeso.mingeso.models.ServiceRoom;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class ServiceDTO implements Serializable {
    private Long serviceId;
    private int type;
    private int price;
    private String serviceName;
    private String managerName;
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
