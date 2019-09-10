package mingeso.services;

import mingeso.models.Student;
import mingeso.repositories.CareerRepository;
import mingeso.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/student")
@CrossOrigin(origins = "*")
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CareerRepository careerRepository;

    @RequestMapping(value = "/{career_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getStudentsByCareer(@PathVariable Long career_id) {
        return studentRepository.findAllByCareerCareerId(career_id);
    }

    @PostMapping
    public void createStudent(@RequestBody Student student_in) {
        Student student = new Student();
        student.setBirthDate(student_in.getBirthDate());
        student.setCareer(careerRepository.findCareerByCareerId(student_in.getCareer().getCareerId()));
        student.setName(student_in.getName());
        student.setRut(student_in.getRut());
        studentRepository.save(student);
    }


}
