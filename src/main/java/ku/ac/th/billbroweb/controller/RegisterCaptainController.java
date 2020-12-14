package ku.ac.th.billbroweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterCaptainController {
    @RequestMapping("/register")
    public String getRegisterPage(Model model) {
        return "register";
    }
}
