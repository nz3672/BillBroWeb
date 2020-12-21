package ku.ac.th.billbroweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class homeController {
    @GetMapping
    public String getLoginPage(){
        return "homePage";
    }
}
