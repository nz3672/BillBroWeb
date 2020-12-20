package ku.ac.th.billbroweb.controller;

import ku.ac.th.billbroweb.model.Crewmate;
import ku.ac.th.billbroweb.service.CrewmateService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class CrewmateController {
    private CrewmateService crewmateService;

    public CrewmateController(CrewmateService crewmateService) {
        this.crewmateService = crewmateService;
    }

    @GetMapping
    public String getCrewmatePage(Model model){
        model.addAttribute("crewmates", crewmateService.getCrewmate());
        return "crewmate";
    }

    @PostMapping
    public String openCrewmate(@ModelAttribute Crewmate crewmate, Model model){
        crewmateService.openCrewmate(crewmate);
        model.addAttribute("crwmates", crewmateService.getCrewmate());
        return "redirect:crewmate";
    }

    @GetMapping("/edit/{id}")
    public String getEditCrewmatePage(@PathVariable int id, Model model){
        Crewmate crewmate = crewmateService.getCrewmate(id);
        model.addAttribute("crewmate", crewmate);
        return "crewmate-edit";
    }

    @PostMapping("/edit/{id}")
    public String editCrewmate(@PathVariable int id, @ModelAttribute Crewmate crewmate, Model model){
        crewmateService.editCrewmate(crewmate);
        model.addAttribute("crewmates", crewmateService.getCrewmate());
        return  "redirect:/crewmate";
    }

    @PostMapping("delete/{id}")
    public String deleteCrewmate(@PathVariable int id,@ModelAttribute Crewmate crewmate, Model model){
        crewmateService.deleteCrewmate(crewmate);
        return "redirect:crewmate";
    }
}
