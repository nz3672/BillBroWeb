package ku.ac.th.billbroweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class HistoryPay {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private int hpId;

    private double hp_dept;
    private double hp_payed;
    private int cmId;

    public HistoryPay() {
    }

    public HistoryPay(int hpId, double hp_dept, double hp_payed, int cmId) {
        this.hpId = hpId;
        this.hp_dept = hp_dept;
        this.hp_payed = hp_payed;
        this.cmId = cmId;
    }

    public void setHp_dept(double hp_dept) {
        this.hp_dept = hp_dept;
    }

    public void setHp_payed(double hp_payed) {
        this.hp_payed = hp_payed;
    }

    public int getCmId() {
        return cmId;
    }

    public void setHpId(int hpId) {
        this.hpId = hpId;
    }

    public void setCmId(int cmId) {
        this.cmId = cmId;
    }

    @Override
    public String toString() {
        return "HistoryPay{" +
                "hpId=" + hpId +
                ", hp_dept=" + hp_dept +
                ", hp_payed=" + hp_payed +
                ", cmId=" + cmId +
                '}';
    }

    public int getHpId() {
        return hpId;
    }

    public double getHp_dept() {
        return hp_dept;
    }

    public double getHp_payed() {
        return hp_payed;
    }

}
