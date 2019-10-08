package mingeso.mingeso;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Assertions;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StudentTest {

    private Student exampleStudent;

    @Autowired
    private CareerRepository careerRepository;

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    public void initializeStudent() {
        exampleStudent = new Student();
        exampleStudent.setName("Sharly");
        exampleStudent.setRut("19876459-1");
    }

    @Test
    @DisplayName("Test for get student name")
    public void studentNameTest() {
        Assertions.assertEquals("Sharly", exampleStudent.getName());
    }

    @Test
    @DisplayName("Test for get student rut")
    public void studentGetRutTest() {
        Assertions.assertEquals("19876459-1", exampleStudent.getRut());
    }
}
