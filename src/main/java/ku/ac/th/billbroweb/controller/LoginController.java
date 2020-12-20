package ku.ac.th.billbroweb.controller;

import ku.ac.th.billbroweb.model.Captain;
import ku.ac.th.billbroweb.service.CaptainService;
import ku.ac.th.billbroweb.service.TaskPartyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    private CaptainService captainService;
    private TaskPartyService taskPartyService;

    public LoginController(CaptainService captainService, TaskPartyService taskPartyService) {
        this.captainService = captainService;
        this.taskPartyService = taskPartyService;
    }

    @GetMapping
    public String getLoginPage(@ModelAttribute Captain captain){
        return "loginPage";
    }

    @PostMapping
    public  String login(@ModelAttribute Captain captain, Model model){
        Captain matchingCap = captainService.checkPin(captain);
        System.out.println(captain);
        if (matchingCap!=null){
            model.addAttribute("captainTitle",matchingCap.getC_id() + " " + matchingCap.getC_name());
            model.addAttribute("taskParty",taskPartyService.getCaptainOfTaskParty(captain.getC_id()));
            return "captainaccount";
        } else {
            model.addAttribute("noting","can't login");
            return "redirect:/login";
        }
    }

}
