package mingeso.mingeso.services;

import mingeso.mingeso.models.Student;
import mingeso.mingeso.repositories.CareerRepository;
import mingeso.mingeso.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @ResponseBody
    public void createStudent(@RequestBody Student student_in) {
        //student_in.setCareer(careerRepository.findCareerByCareerId(student_in.getCareer().getCareerId()));
        student_in.setCareer(careerRepository.findCareerByName(student_in.getCareer().getName()));
        studentRepository.save(student_in);
    }
}
