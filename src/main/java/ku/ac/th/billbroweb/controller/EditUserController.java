package ku.ac.th.billbroweb.controller;


import ku.ac.th.billbroweb.model.Captain;
import ku.ac.th.billbroweb.service.CaptainService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userdetail")
public class EditUserController {

    @Autowired
    private CaptainService captainService;

    @GetMapping
    public String getEditPage(Model model, Authentication authentication) {
        model.addAttribute("captain", captainService.findCaptain(authentication.getName()));
        model.addAttribute("capName","Welcome ," + captainService.findCaptain(authentication.getName()).getC_name());
        return "editUserPage";
    }

    /*@PostMapping
    public String edituserPost(@ModelAttribute Captain captain, Authentication authentication) {
        System.out.println(captain.getC_pwd());
        if (captain.getC_pwd() == null || captain.getC_pwd().length() == 0) {
            captain.setC_pwd(captainService.findCaptain(authentication.getName()).getC_pwd());
        } else {
            captain.setC_pwd(BCrypt.hashpw( captain.getC_pwd(), BCrypt.gensalt(12) ));
        }
        captain.setC_id(captainService.findCaptain(authentication.getName()).getC_id());
        captainService.editCaptain(captain);
        return "redirect:/home";
    }*/
}
