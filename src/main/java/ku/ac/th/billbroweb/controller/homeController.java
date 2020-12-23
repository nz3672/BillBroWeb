package ku.ac.th.billbroweb.controller;

import ku.ac.th.billbroweb.model.TaskParty;
import ku.ac.th.billbroweb.service.AuthService;
import ku.ac.th.billbroweb.service.CaptainService;
import ku.ac.th.billbroweb.service.TaskPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class homeController {
    @Autowired
    private CaptainService captainService;

    @Autowired
    private TaskPartyService taskPartyService;

    @GetMapping
    public String getLoginPage(Authentication authentication, Model model){
        model.addAttribute("taskParty",taskPartyService.getCaptainOfTaskParty(captainService.findCaptain(authentication.getName()).getC_id()));
        return "homePage";
    }

    @PostMapping
    public String geteditPage(@ModelAttribute TaskParty taskParty) {
        System.out.println(taskParty.gettId());
        return "test";
    }
}
