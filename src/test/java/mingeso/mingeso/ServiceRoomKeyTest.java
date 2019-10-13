package mingeso.mingeso;

import mingeso.mingeso.models.ServiceRoomKey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ServiceRoomKeyTest {

    private ServiceRoomKey serviceRoomKey;
    /*
    @BeforeEach
    public void initializeServiceRoomKey() {
        serviceRoomKey = new ServiceRoomKey();
        long serviceRoomKeyId = 5;
        serviceRoomKey.setRoomId(serviceRoomKeyId);
        serviceRoomKey.setServiceId(serviceRoomKeyId);
    }
    */

    /*
    @Test
    @DisplayName("Test for get room Id")
    public void getRoomIdTest() {
        long id = 5;
        long realId = serviceRoomKey.getRoomId();
        Assertions.assertEquals(id, realId);
    }
    */

    /*
    @Test
    @DisplayName("Test for get service id")
    public void getServiceId() {
        long id = 5;
        long realId = serviceRoomKey.getServiceId();
        Assertions.assertEquals(id, realId);
    }
    */
}
