package mingeso.mingeso.services;

import mingeso.mingeso.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/service")
@CrossOrigin(origins = "*")
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;
}
