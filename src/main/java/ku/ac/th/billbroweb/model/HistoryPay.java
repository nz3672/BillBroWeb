package ku.ac.th.billbroweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HistoryPay {

    private int hp_id;

    private double hp_dept;
    private double hp_payed;

    public HistoryPay() {
    }

    public HistoryPay(int hp_id, double hp_dept, double hp_payed) {
        this.hp_id = hp_id;
        this.hp_dept = hp_dept;
        this.hp_payed = hp_payed;
    }

    public void setHp_dept(double hp_dept) {
        this.hp_dept = hp_dept;
    }

    public void setHp_payed(double hp_payed) {
        this.hp_payed = hp_payed;
    }

    public int getHp_id() {
        return hp_id;
    }

    public double getHp_dept() {
        return hp_dept;
    }

    public double getHp_payed() {
        return hp_payed;
    }

    @Override
    public String toString() {
        return "HistoryPay{" +
                "hp_id=" + hp_id +
                ", hp_dept=" + hp_dept +
                ", hp_payed=" + hp_payed +
                '}';
    }
}
