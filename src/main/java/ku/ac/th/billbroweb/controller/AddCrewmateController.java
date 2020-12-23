package ku.ac.th.billbroweb.controller;


import ku.ac.th.billbroweb.model.*;
import ku.ac.th.billbroweb.service.CrewmateService;
import ku.ac.th.billbroweb.service.HistoryPayService;
import ku.ac.th.billbroweb.service.TaskPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/addcrewmate")
public class AddCrewmateController {

    private int friendnum;
    private TaskParty taskParty;

    @Autowired
    private CrewmateService crewmateService;

    @Autowired
    private HistoryPayService historyPayService;

    @Autowired
    private TaskPartyService taskPartyService;


    @GetMapping
    public String getAddTaskofCrewmate(Model model, @ModelAttribute CrewmateWrapper crewmateWrapper) {
        this.taskParty = (TaskParty) model.asMap().get("taskpartyobj");
        this.friendnum = (int) model.asMap().get("u");
        ArrayList<CrewmateAdd> crewmateArrayList = new ArrayList<>();
        for(int i = 0; i < friendnum; i++) {
            crewmateArrayList.add(new CrewmateAdd(new Crewmate(), new HistoryPay()));
        }

        model.addAttribute("perPrice", Double.toString(taskParty.getT_price()/friendnum));
        model.addAttribute("crewmateWrapper", new CrewmateWrapper(crewmateArrayList));
        System.out.println(taskParty.getC_id());
        return "AddTaskofCrewmate";
    }


    @PostMapping
    public String testing(@ModelAttribute CrewmateWrapper crewmateAdds, Model model) {
        taskParty.setT_state("กำลังดำเนินการ");
        taskPartyService.openTaskParty(taskParty);
//        for (int i = 0 ; i < friendnum ; i++) {
//            Crewmate crewmate = crewmates.getCrewmateAdds().get(i).getCrewmate();
//            crewmate.settId(taskPartyService.getTaskParty());
//            crewmateService.openCrewmate();
//        }
        return "test";
    }
}
