package mingeso.mingeso;

import mingeso.mingeso.models.Client;
import mingeso.mingeso.repositories.ClientRepository;
import mingeso.mingeso.services.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    @Test
    @DisplayName("Test for get all clients")
    public void getClientsTest() {
        Client client = new Client();
        client.setMail("hola");
        List<Client> clients;
        doReturn(Arrays.asList(client)).when(clientRepository).findAll();

        clients = clientService.getAll();
        Assertions.assertEquals(1, clients.size());

    }

    @Test
    @DisplayName("Test for get by id")
    public void getByIdTest() {
        Client client = new Client();
        Client client1;
        long id = 5;
        client.setClientId(id);
        doReturn(Optional.of(client)).when(clientRepository).findById(id);

        client1 = clientService.getById(id);
        Assertions.assertEquals(client, client1);
    }

    @Test
    @DisplayName("Test for create client")
    public void createClientTest() {
        Client client = new Client();
        when(clientService.create(client)).thenReturn(new ResponseEntity(client, HttpStatus.CREATED));
        Assertions.assertEquals(client, client);
    }
}
