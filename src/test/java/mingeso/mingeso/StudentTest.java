package mingeso.mingeso;

import mingeso.mingeso.models.Career;
import mingeso.mingeso.models.Student;
import mingeso.mingeso.repositories.CareerRepository;
import mingeso.mingeso.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Assertions;

import javax.validation.constraints.Null;
import java.util.List;

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

    @Test
    @DisplayName("Test for get all student")
    public void findAllStudentsTest() {
        List<Student> allStudents;
        allStudents = studentRepository.findAll();
        Assertions.assertEquals(2, allStudents.size());
    }
}
