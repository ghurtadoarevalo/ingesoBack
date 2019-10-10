package mingeso.mingeso;

import mingeso.mingeso.models.Role;
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
public class ClientTest {

    private User user;

    private Role role;

    @BeforeEach
    public void initializaUser() {
        user = new User();
        role = new Role();
        long userId = 5;
        role.setRoleId(userId);
        user.setUserId(userId);
        user.setPassword("Hola");
        user.setContact("1818");
        user.setName("Matias");
        user.setRole(role);
    }

    @Test
    @DisplayName("Test for get role id")
    public void getUserIdTest() {
        long id = 5;
        long realId = user.getUserId();
        Assertions.assertEquals(id, realId);
    }

    @Test
    @DisplayName("Test for get password")
    public void getPasswordTest() {
        Assertions.assertEquals("Hola", user.getPassword());
    }

    @Test
    @DisplayName("Test for get name")
    public void getNameTest() {
        Assertions.assertEquals("Matias", user.getName());
    }

    @Test
    @DisplayName("Test for get contact")
    public void getContactTest() {
        Assertions.assertEquals("1818", user.getContact());
    }

    @Test
    @DisplayName("Test for get role")
    public void getRoleTest() {
        Assertions.assertEquals(role, user.getRole());
    }
}
