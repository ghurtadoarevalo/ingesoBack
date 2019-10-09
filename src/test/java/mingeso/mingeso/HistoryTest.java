package mingeso.mingeso;

import mingeso.mingeso.models.History;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HistoryTest {

    private History history;

    @BeforeEach
    public void initializeHistory() {

        history = new History();
        long historyId = 5;
        history.setAditionalInfo("Hola");
        history.setHistoryId(historyId);
    }

    @Test
    @DisplayName("Test for get aditional info")
    public void getAditionalInfoTest() {
        Assertions.assertEquals("Hola", history.getAditionalInfo());
    }

    @Test
    @DisplayName("Test for get history id")
    public void getHistoryIdTest() {
        long historyId = 5;
        long realHistoryId = history.getHistoryId();
        Assertions.assertEquals(historyId, realHistoryId);
    }
}
