package mingeso.mingeso;

import mingeso.mingeso.models.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
    public class ServiceTest {

    private Service service;

    @BeforeEach
    public void initializeService() {
        service = new Service();
        long serviceId = 5;
        service.setPrice(1000);
        service.setServiceName("Piscina");
        service.setType(0);
        service.setManagerName("Matias");
        service.setServiceId(serviceId);
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
}
