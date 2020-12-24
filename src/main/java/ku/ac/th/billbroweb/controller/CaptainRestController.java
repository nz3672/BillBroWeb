package ku.ac.th.billbroweb.controller;

import ku.ac.th.billbroweb.data.CaptainRepository;
import ku.ac.th.billbroweb.model.Captain;
//import ku.ac.th.billbroweb.playload.request.RegisterRequest;
import ku.ac.th.billbroweb.service.CaptainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/captain")
public class CaptainRestController {
    @Autowired
    private CaptainService captainService;
    private CaptainRepository captainRepository;

    public CaptainRestController(CaptainService captainService) {
        this.captainService = captainService;
    }

    @GetMapping
    public List<Captain> getAll(){
        return captainService.getCaptain();
    }

    @GetMapping("/{c_username}")
    public Captain getCaptainbyusername(@PathVariable String c_username){
        return captainService.findCaptain(c_username);
    }

    @PutMapping("/{id}")
    public Captain update(@PathVariable int id, @RequestBody Captain captain){
        Captain record = captainRepository.findById(id).get();
        record.setC_pwd(captain.getC_pwd());
        record.setC_email(captain.getC_email());
        record.setC_name(captain.getC_name());
        record.setcUsername(captain.getcUsername());
        captainRepository.save(record);
        return record;
    }

}
