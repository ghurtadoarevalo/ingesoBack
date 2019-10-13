package mingeso.mingeso;

import mingeso.mingeso.dto.HistoryDTO;
import mingeso.mingeso.models.Client;
import mingeso.mingeso.models.History;
import mingeso.mingeso.repositories.ClientRepository;
import mingeso.mingeso.repositories.HistoryRepository;
import mingeso.mingeso.services.HistoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HistoryServiceTest {

    @Mock
    HistoryRepository historyRepository;

    @Mock
    ClientRepository clientRepository;

    @InjectMocks
    HistoryService historyService;

    @Test
    @DisplayName("Test for get all Histories")
    public void getAllHistoryTest() {
        History history = new History();
        List<History> histories = new ArrayList<>();
        doReturn(Arrays.asList(history)).when(historyRepository).findAll();
        histories = historyService.getAll();
        Assertions.assertEquals(histories, histories);
    }

    @Test
    @DisplayName("Test for create history")
    public void createHistoryTest() {
        HistoryDTO historyDTO = new HistoryDTO();
        long id = 5;
        Client client = new Client();
        client.setClientId(id);
        historyDTO.setClient(client);
        doReturn(Optional.of(client)).when(clientRepository).findById(id);
        historyService.create(historyDTO);
        Assertions.assertEquals(historyDTO, historyDTO);
    }
}
