package mingeso.mingeso;

import mingeso.mingeso.models.Service;
import mingeso.mingeso.models.ServiceRoom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.ArrayList;

@ExtendWith(SpringExtension.class)
@SpringBootTest
    public class ServiceTest {

    private Service service;

    private ArrayList<ServiceRoom> serviceRooms;

    @BeforeEach
    public void initializeService() {
        service = new Service();
        serviceRooms = new ArrayList<>();
        ServiceRoom serviceRoom = new ServiceRoom();
        Date date = java.sql.Date.valueOf("2019-03-13");
        serviceRoom.setDate(date);
        serviceRooms.add(serviceRoom);
        long serviceId = 5;
        service.setPrice(1000);
        service.setServiceName("Piscina");
        service.setType(0);
        service.setManagerName("Matias");
        service.setServiceId(serviceId);
        service.setServiceRooms(serviceRooms);
    }

    @Test
    @DisplayName("Test for get price")
    public void getPriceTest() {
        Assertions.assertEquals(1000, service.getPrice());
    }

    @Test
    @DisplayName("Test for get service name")
    public void getServiceNameTest() {
        Assertions.assertEquals("Piscina", service.getServiceName());
    }

    @Test
    @DisplayName("Test for get type")
    public void getTypeTest() {
        Assertions.assertEquals(0, service.getType());
    }

    @Test
    @DisplayName("Test for get manager name")
    public void getManagerNameTest() {
        Assertions.assertEquals("Matias", service.getManagerName());
    }

    @Test
    @DisplayName("Test for get id")
    public void getServiceIdTest() {
        long idAux = 5;
        long realId = service.getServiceId();
        Assertions.assertEquals(idAux, realId);
    }

    @Test
    @DisplayName("Test for get service rooms")
    public void getServiceRoomsTest() {
        Assertions.assertEquals(serviceRooms, service.getServiceRooms());
    }
}
