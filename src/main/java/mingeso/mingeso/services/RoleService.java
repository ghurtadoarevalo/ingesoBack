package mingeso.mingeso.services;

import mingeso.mingeso.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/role")
@CrossOrigin(origins = "*")
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;
}
