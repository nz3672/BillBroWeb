package ku.ac.th.billbroweb.controller;

import ku.ac.th.billbroweb.model.TaskParty;
import ku.ac.th.billbroweb.service.TaskPartyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task-party")
public class TaskPartyController {
    private TaskPartyService taskPartyService;

    public TaskPartyController(TaskPartyService taskPartyService) {
        this.taskPartyService = taskPartyService;
    }

    @GetMapping
    public String getTaskPartyPage(Model model){
        model.addAttribute("task-partys", taskPartyService.getTaskParty());
        return "task-party";
    }

    @PostMapping
    public String opendTaskParty(@ModelAttribute TaskParty taskParty, Model model){
        taskPartyService.openTaskParty(taskParty);
        model.addAttribute("task-partys", taskPartyService.getTaskParty());
        return "redirect:task-party";
    }

    @GetMapping("/edit/{id}")
    public String getEditTaskPartyPage(@PathVariable int id, Model model){
        TaskParty taskParty = taskPartyService.getTaskParty(id);
        model.addAttribute("task-party", taskParty);
        return "task-party-edit";
    }

    @PostMapping("/edit/{id}")
    public String editTaskParty(@PathVariable int id, @ModelAttribute TaskParty taskParty, Model model){
        taskPartyService.editTaskParty(taskParty);
        model.addAttribute("task-partys", taskPartyService.getTaskParty());
        return "redirect:/task-party";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id, @ModelAttribute TaskParty taskParty, Model model){
        taskPartyService.deleteTaskParty(taskParty);
        return "redirect:/task-party";
    }
}
