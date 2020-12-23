package ku.ac.th.billbroweb.model;

import java.util.List;

public class HistoryPayWrapper {
    private List<HistoryPay> historyPays;

    public HistoryPayWrapper(List<HistoryPay> historyPays) {
        this.historyPays = historyPays;
    }

    public void addHistoryPay(HistoryPay historyPay) {
        this.historyPays.add(historyPay);
    }

    public List<HistoryPay> getHistoryPays() {
        return historyPays;
    }

    public void setHistoryPays(List<HistoryPay> historyPays) {
        this.historyPays = historyPays;
    }
}
