package ku.ac.th.billbroweb.controller;

import ku.ac.th.billbroweb.model.HistoryPay;
import ku.ac.th.billbroweb.service.HistoryPayService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class HistoryPayController {
    private HistoryPayService historyPayService;

    public HistoryPayController(HistoryPayService historyPayService) {
        this.historyPayService = historyPayService;
    }

    @GetMapping
    public String getHistoryPayPage(Model model){
        model.addAttribute("history-pay", historyPayService.getHistoryPay());
        return "history-pay";
    }

    @PostMapping
    public String openHistoryPay(@ModelAttribute HistoryPay historyPay, Model model){
        historyPayService.openHistoryPay(historyPay);
        model.addAttribute("history-pays", historyPayService.getHistoryPay());
        return "redirect:history-pay";
    }

    @GetMapping("/edit/{id}")
    public String getEditHistoryPayPage(@PathVariable int id, Model model){
        HistoryPay historyPay = historyPayService.getHistoryPay(id);
        model.addAttribute("history-pay", historyPay);
        return "history-pay-edit";
    }

    @PostMapping("/edit/{id}")
    public String editHistoryPay(@PathVariable int id, @ModelAttribute HistoryPay historyPay, Model model){
        historyPayService.editHistoryPay(historyPay);
        model.addAttribute("history-pays", historyPayService.getHistoryPay());
        return  "redirect:/history-pay";
    }

    @PostMapping("delete/{id}")
    public String deleteHistoryPay(@PathVariable int id,@ModelAttribute HistoryPay historyPay, Model model){
        historyPayService.deleteHistoryPay(historyPay);
        return "redirect:history-pay";
    }
}
