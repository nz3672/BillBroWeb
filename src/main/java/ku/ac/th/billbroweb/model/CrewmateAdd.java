package ku.ac.th.billbroweb.model;

import java.util.List;

public class CrewmateAdd {
    private Crewmate crewmate;
    private HistoryPay historyPay;

    public CrewmateAdd(Crewmate crewmate, HistoryPay historyPay) {
        this.crewmate = crewmate;
        this.historyPay = historyPay;
    }

    public CrewmateAdd(Crewmate crewmate) {
        this.crewmate = crewmate;
    }

    public CrewmateAdd(HistoryPay historyPay) {
        this.historyPay = historyPay;
    }

    public CrewmateAdd() {
    }

    public Crewmate getCrewmate() {
        return crewmate;
    }

    public void setCrewmate(Crewmate crewmate) {
        this.crewmate = crewmate;
    }

    public HistoryPay getHistoryPay() {
        return historyPay;
    }

    public void setHistoryPay(HistoryPay historyPay) {
        this.historyPay = historyPay;
    }
}
