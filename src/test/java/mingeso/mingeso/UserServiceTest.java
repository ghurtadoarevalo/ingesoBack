package mingeso.mingeso;

import mingeso.mingeso.dto.UserDTO;
import mingeso.mingeso.models.Role;
import mingeso.mingeso.models.User;
import mingeso.mingeso.repositories.RoleRepository;
import mingeso.mingeso.repositories.UserRepository;
import mingeso.mingeso.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    RoleRepository roleRepository;

    @InjectMocks
    UserService userService;

    @Test
    @DisplayName("Test for get roles of user")
    public void getRolesTest() {
        Role role = new Role();
        long rolId = 5;
        role.setRoleId(rolId);
        User user = new User();
        user.setRole(role);
        doReturn(Arrays.asList(user)).when(userRepository).findAll();
        doReturn(Optional.of(role)).when(roleRepository).findById(rolId);
        userService.getUsersByRol(rolId);
        Assertions.assertEquals(role, role);
    }

    @Test
    @DisplayName("Test for create user")
    public void userCreateTest() {
        Role role = new Role();
        UserDTO user = new UserDTO();
        long rolId = 5;
        user.setPassword("password");
        user.setContact("0192");
        user.setName("Franco");
        role.setRoleId(rolId);
        user.setRole(role);
        doReturn(Optional.of(role)).when(roleRepository).findById(rolId);
        userService.create(user);
        Assertions.assertEquals(user, user);
    }

}
