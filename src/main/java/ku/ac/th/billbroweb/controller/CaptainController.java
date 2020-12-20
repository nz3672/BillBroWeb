package ku.ac.th.billbroweb.controller;

import ku.ac.th.billbroweb.model.Captain;
import ku.ac.th.billbroweb.service.CaptainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/captain")
public class CaptainController {
    private CaptainService captainService;

    public CaptainController(CaptainService captainService) {
        this.captainService = captainService;
    }
    @GetMapping
    public String getCaptainPage(Model model){
        model.addAttribute("allCaptains",captainService.getCaptain());
        return "captain";
    }

    @PostMapping
    public String registerCaptain(@ModelAttribute Captain captain, Model model){
        captainService.createCaptain(captain);
        model.addAttribute("allCaptains",captainService.getCaptain());
        return "redirect:captain";
    }

}
