package ku.ac.th.billbroweb.controller;


import ku.ac.th.billbroweb.model.*;
import ku.ac.th.billbroweb.service.CrewmateService;
import ku.ac.th.billbroweb.service.EmailService;
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

    @Autowired
    private EmailService emailService;


    @GetMapping
    public String getAddTaskofCrewmate(Model model, @ModelAttribute CrewmateWrapper crewmateWrapper) {
        if(model.asMap().isEmpty()) {
            return "redirect:/home";
        }
        this.taskParty = (TaskParty) model.asMap().get("taskpartyobj");
        this.friendnum = (int) model.asMap().get("u");
        ArrayList<CrewmateAdd> crewmateArrayList = new ArrayList<>();
        for(int i = 0; i < friendnum; i++) {
            crewmateArrayList.add(new CrewmateAdd(new Crewmate(), new HistoryPay()));
        }

        model.addAttribute("perPrice", Double.toString(taskParty.getT_price()/friendnum));
        model.addAttribute("crewmateWrapper", new CrewmateWrapper(crewmateArrayList));
        return "AddTaskofCrewmate";
    }


    @PostMapping
    public String testing(@ModelAttribute CrewmateWrapper crewmateAdds, Model model) {
        taskParty.setT_state("กำลังดำเนินการ");
        taskPartyService.openTaskParty(taskParty);
        int taskiD = taskPartyService.getTaskParty().get(taskPartyService.getTaskParty().size()-1).gettId();
        for (int i = 0 ; i < friendnum ; i++) {
            Crewmate crewmate = crewmateAdds.getCrewmateAdds().get(i).getCrewmate();

            crewmate.setCm_state("paying");
            crewmate.settId(taskiD);
            crewmateService.openCrewmate(crewmate);

            int cmid = crewmateService.getCrewmate().get(crewmateService.getCrewmate().size()-1).getCmId();

            HistoryPay historyPay = crewmateAdds.getCrewmateAdds().get(i).getHistoryPay();
            historyPay.setCmId(cmid);

            historyPayService.openHistoryPay(historyPay);
            emailService.sent(taskParty,crewmate,historyPay);
        }
        return "redirect:/home";
    }
}
