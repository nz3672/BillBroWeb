package ku.ac.th.billbroweb.controller;


import ku.ac.th.billbroweb.model.Captain;
import ku.ac.th.billbroweb.service.CaptainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private CaptainService captainService;

    public RegisterController(CaptainService captainService) {
        this.captainService = captainService;
    }

    @GetMapping
    public String getRegisterPage(@ModelAttribute Captain captain){
        return "registerPage";
    }

    @PostMapping
    public String postRegister(@ModelAttribute Captain captain){
        captainService.createCaptain(captain);
        return "redirect:/login";
    }
}
