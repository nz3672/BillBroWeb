package ku.ac.th.billbroweb.controller;

import ku.ac.th.billbroweb.model.Crewmate;
import ku.ac.th.billbroweb.model.HistoryPay;
import ku.ac.th.billbroweb.model.TaskParty;
import ku.ac.th.billbroweb.service.CrewmateService;
import ku.ac.th.billbroweb.service.HistoryPayService;
import ku.ac.th.billbroweb.service.TaskPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/task-party")
public class TaskPartyController {
    @Autowired
    private TaskPartyService taskPartyService;

    @Autowired
    private CrewmateService crewmateService;

    @Autowired
    private HistoryPayService historyPayService;

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
    public String getEditTaskPartyPage(@PathVariable int id, Model model, HttpSession session){
        TaskParty taskParty = taskPartyService.getTaskParty(id);
        System.out.println(taskParty);
        taskParty.settId(id);
        session.setAttribute("taskparty", taskParty);
        return "redirect:/editTask";
    }

    @PostMapping("/edit/{id}")
    public String editTaskParty(@PathVariable int id, @ModelAttribute TaskParty taskParty, Model model, RedirectAttributes redirectAttributes){
        taskPartyService.editTaskParty(taskParty);
        redirectAttributes.addFlashAttribute("taskParty", taskParty);
        return "redirect:/editcrewmate";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id, @ModelAttribute TaskParty taskParty, Model model){
        taskPartyService.deleteTaskParty(taskParty);
        return "redirect:/task-party";
    }
}
