package mingeso.mingeso;

import mingeso.mingeso.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserTest {

    private User user;

    @BeforeEach
    public void initializeUser() {
        user = new User();
        long userId = 7;
        user.setName("Matias");
        user.setContact("60593895");
        user.setMail("Matias@matias.cl");
        user.setPassword("ricolino");
        user.setRut("1235678-2");
        user.setUserId(userId);
    }

    @Test
    @DisplayName("Test for get user id")
    public void getUserIdTest() {
        long userId = 7;
        long realUserId = user.getUserId();
        Assertions.assertEquals(userId, realUserId);
    }

    @Test
    @DisplayName("Test for get user name")
    public void getUserNameTest() {
        Assertions.assertEquals("Matias", user.getName());
    }

    @Test
    @DisplayName("Test for get user contact")
    public void getUserContactTest() {
        Assertions.assertEquals("60593895", user.getContact());
    }

    @Test
    @DisplayName("Test for get user mail")
    public void getUserMailTest() {
        Assertions.assertEquals("Matias@matias.cl", user.getMail());
    }

    @Test
    @DisplayName("Test for get user rut")
    public void getUserRutTest() {
        Assertions.assertEquals("1235678-2", user.getRut());
    }

    @Test
    @DisplayName("Test for get user password")
    public void getUserPassword() {
        Assertions.assertEquals("ricolino", user.getPassword());
    }
}
