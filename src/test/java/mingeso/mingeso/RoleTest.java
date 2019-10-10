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
public class RoleTest {

    private Role role;
    private Role secondRole;

    @BeforeEach
    public void initializeRole() {
        role = new Role();
        User user = new User();
        secondRole = new Role(0, user);
        long roleId = 5;
        role.setRoleId(roleId);
        role.setType(0);
    }

    @Test
    @DisplayName("Test for get role Id")
    public void getRoleIdTest() {
        long roleId = 5;
        long realRoleId = role.getRoleId();
        Assertions.assertEquals(roleId, realRoleId);
    }

    @Test
    @DisplayName("Test for get role type")
    public void getRoleTypeTest() {
        Assertions.assertEquals(0, role.getType());
    }
}
