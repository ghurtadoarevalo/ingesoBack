package mingeso.services;
import mingeso.models.Career;
import mingeso.repositories.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/career")
@CrossOrigin(origins = "*")
public class CareerService {

    @Autowired
    private CareerRepository careerRepository;

    @RequestMapping(value = "/getCareers", method = RequestMethod.GET)
    @ResponseBody
    public List<Career> getCareers() {
        return careerRepository.findAll();
    }

    @RequestMapping(value = "/{career_id}", method = RequestMethod.GET)
    @ResponseBody
    public Career getCareer(@PathVariable Long career_id) {
        return careerRepository.findCareerByCareerId(career_id);
    }

}
