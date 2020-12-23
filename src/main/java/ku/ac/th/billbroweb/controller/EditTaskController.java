package ku.ac.th.billbroweb.controller;


import ku.ac.th.billbroweb.model.TaskParty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/editTask")
public class EditTaskController {

    @GetMapping
    public String geteditTask(HttpSession session, Model model) {
        model.addAttribute("taskParty", session.getAttribute("taskparty"));
        return "editTask";
    }
}
