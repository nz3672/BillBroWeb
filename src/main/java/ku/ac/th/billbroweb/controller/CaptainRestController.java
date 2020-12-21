package ku.ac.th.billbroweb.controller;

import ku.ac.th.billbroweb.data.CaptainRepository;
import ku.ac.th.billbroweb.model.Captain;
import ku.ac.th.billbroweb.service.CaptainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/captain")
public class CaptainRestController {
    private CaptainService captainService;

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

//    @GetMapping("/{c_id}")
//    public Captain getOne(@PathVariable int c_id){
//        return captainService.findCaptain(c_id);
//    }
}
