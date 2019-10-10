package mingeso.mingeso.services;

import mingeso.mingeso.dto.HistoryDTO;
import mingeso.mingeso.models.History;
import mingeso.mingeso.repositories.HistoryRepository;
import mingeso.mingeso.repositories.ClientRepository;
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
    private ClientRepository clientRepository;

    @GetMapping(value = "/histories")
    @ResponseBody
    public ResponseEntity getAll() {
        List<History> histories = historyRepository.findAll();
        return new ResponseEntity(histories, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity create(@RequestBody HistoryDTO historyDTO) {
        if (clientRepository.findById(historyDTO.getClient().getClientId()).isPresent()) {
            History persistenHistory = new History();
            persistenHistory.setAditionalInfo(historyDTO.getAditionalInfo());
            persistenHistory.setClient(historyDTO.getClient());
            return new ResponseEntity(historyRepository.save(persistenHistory), HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
