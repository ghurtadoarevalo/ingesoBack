package mingeso.mingeso.services;

import mingeso.mingeso.models.Hotel;
import mingeso.mingeso.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/hotel")
@CrossOrigin(origins = "*")
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;
}
