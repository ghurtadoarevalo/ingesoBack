package mingeso.mingeso.services;

import mingeso.mingeso.models.History;
import mingeso.mingeso.models.User;
import mingeso.mingeso.repositories.HistoryRepository;
import mingeso.mingeso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/history")
@CrossOrigin(origins = "*")
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/histories")
    @ResponseBody
    public ResponseEntity getAll() {
        List<History> histories = historyRepository.findAll();
        return new ResponseEntity(histories, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity create(@RequestBody History history) {
        if(null == userRepository.findById(history.getUser().getUserId())){
            return new ResponseEntity(HttpStatus.NOT_FOUND);}
        else{
            History newHistory = new History();
            newHistory.setAditionalInfo(history.getAditionalInfo());
            newHistory.setUser(history.getUser());
            return new ResponseEntity(historyRepository.save(history), HttpStatus.CREATED);
        }
    }
}
