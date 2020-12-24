package ku.ac.th.billbroweb.controller;


import ku.ac.th.billbroweb.model.*;
import ku.ac.th.billbroweb.service.CrewmateService;
import ku.ac.th.billbroweb.service.EmailService;
import ku.ac.th.billbroweb.service.HistoryPayService;
import ku.ac.th.billbroweb.service.TaskPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/editcrewmate")
public class EditCrewmateController {

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
    public String getEditTask(Model model, @ModelAttribute CrewmateWrapper crewmateWrapper) {
        this.taskParty = (TaskParty) model.asMap().get("taskParty");

        List<Crewmate> crewmateList = crewmateService.getCrewmateOfTaskParty(taskParty.gettId());

        ArrayList<CrewmateAdd> crewmateArrayList = new ArrayList<>();
        for (Crewmate crewmate : crewmateList) {
            List<HistoryPay> historyPayList = historyPayService.getHistoryPayOfCrewmate(crewmate.getCmId());
            crewmateArrayList.add(new CrewmateAdd(crewmate,historyPayList.get(0)));
            System.out.println(historyPayList.get(0));
        }
        model.addAttribute("perPrice", crewmateArrayList.get(0).getCrewmate().getCm_per_price());
        model.addAttribute("crewmateWrapper", new CrewmateWrapper(crewmateArrayList));
        return "EditTaskOfCrewmate";
    }


    @PostMapping
    public String testing(@ModelAttribute CrewmateWrapper crewmateAdds, Model model) {
        int taskiD = taskPartyService.getTaskParty().get(taskPartyService.getTaskParty().size()-1).gettId();
        for (int i = 0 ; i < crewmateAdds.getCrewmateAdds().size() ; i++) {
            Crewmate crewmate = crewmateAdds.getCrewmateAdds().get(i).getCrewmate();
            HistoryPay historyPay = crewmateAdds.getCrewmateAdds().get(i).getHistoryPay();
            if (historyPay.getHp_payed() >= crewmate.getCm_per_price()) {
                crewmate.setCm_state("payed");
            } else {
                crewmate.setCm_state("paying");
            }
            String oldEmail = crewmate.getCm_email();

            crewmate.settId(taskiD);
            crewmateService.editCrewmate(crewmate);

            historyPay.setCmId(crewmate.getCmId());

            historyPayService.editHistoryPay(historyPay);

           // if (!oldEmail.equals(crewmate.getCm_email())){
               // System.out.println(oldEmail);
               // System.out.println(crewmate.getCm_email());
                //emailService.sent(taskParty,crewmate,historyPay);
            //}
        }
        return "redirect:/home";
    }
}
