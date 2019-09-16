package mingeso.mingeso;

import mingeso.mingeso.models.Career;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CareerTest {

    private Career exampleCareer;

    @BeforeEach
    public void initializeCareer() {
        exampleCareer = new Career();
        exampleCareer.setName("Ingenieria Informatica");
    }

    @Test
    @DisplayName("Test for get career name")
    public void getCareerNameTest() {
        Assertions.assertEquals("Ingenieria Informatica", exampleCareer.getName());
    }

}
