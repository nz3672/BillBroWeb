package ku.ac.th.billbroweb.controller;

import ku.ac.th.billbroweb.model.Captain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/newtask")
public class NewTaskController {

    @GetMapping
    public String getNewTask(){
        return "NewTask";
    }

    @PostMapping
    public  String posttoAddTask(){
        return "AddTaskOfCrewmate";
    }
}
