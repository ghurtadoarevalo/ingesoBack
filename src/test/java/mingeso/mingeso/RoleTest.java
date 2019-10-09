package mingeso.mingeso;

import mingeso.mingeso.models.Role;
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

    @BeforeEach
    public void initializeRole() {
        Role role = new Role();
        long roleId = 5;
        role.setRoleId(roleId);
        role.setType(0);
    }

    @Test
    @DisplayName("Test for get role Id")
    public void getRoleIdTest() {
        long roleId = 0;
        long realRoleId = role.getRoleId();
        Assertions.assertEquals(0, realRoleId);
    }

    @Test
    @DisplayName("Test for get role type")
    public void getRoleTypeTest() {
        Assertions.assertEquals(0, role.getType());
    }
}
