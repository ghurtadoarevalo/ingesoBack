package mingeso.mingeso.services;

import mingeso.mingeso.models.History;
import mingeso.mingeso.repositories.HistoryRepository;
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
        return new ResponseEntity(historyRepository.save(history), HttpStatus.CREATED);
    }
}
