package ku.ac.th.billbroweb.controller;

import ku.ac.th.billbroweb.model.Captain;
import ku.ac.th.billbroweb.service.CaptainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/register-captain")
public class RegisterCaptainRestController {
    private CaptainService captainService;

    public RegisterCaptainRestController(CaptainService captainService) {
        this.captainService = captainService;
    }

    @GetMapping
    public List<Captain> getAll(){
        return captainService.getCaptain();
    }

    @GetMapping("/{c_id}")
    public Captain getOne(@PathVariable int c_id){
        return captainService.findCaptain(c_id);
    }
}
