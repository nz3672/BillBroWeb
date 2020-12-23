package ku.ac.th.billbroweb.controller;

import ku.ac.th.billbroweb.model.Captain;
import ku.ac.th.billbroweb.playload.request.LoginRequest;
import ku.ac.th.billbroweb.service.AuthService;
import ku.ac.th.billbroweb.service.CaptainService;
import ku.ac.th.billbroweb.service.TaskPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login")
public class LoginController {
    private CaptainService captainService;
    private TaskPartyService taskPartyService;
    @Autowired
    private AuthService authService;

    public LoginController(CaptainService captainService, TaskPartyService taskPartyService) {
        this.captainService = captainService;
        this.taskPartyService = taskPartyService;
    }

    @GetMapping
    public String getLoginPage(@ModelAttribute Captain captain){
        return "loginPage";
    }

    /*@PostMapping
    public  String login(@ModelAttribute Captain captain, Model model,RedirectAttributes redirectAttributes ,@RequestBody LoginRequest loginRequest){
        *//*Captain matchingCap = captainService.checkPin(captain);
        if (matchingCap!=null){
            redirectAttributes.addFlashAttribute("captainTitle",matchingCap.getC_id() + " " + matchingCap.getC_name());
            redirectAttributes.addFlashAttribute("taskParty",taskPartyService.getCaptainOfTaskParty(matchingCap.getC_id()));
            return "redirect:/home";
        } else {
            model.addAttribute("noting","can't login");
            return "redirect:/login";
        }*//*
        return authService.login(loginRequest);

    }
*/
}
