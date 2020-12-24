package ku.ac.th.billbroweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class TaskParty {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private int tId;

    private String t_name;
    private String t_res;
    private String t_date;
    private Double t_price;
    private String t_state;
    private int cId;

    public TaskParty() {
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public TaskParty(int tId, String t_name, String t_res, String t_date, Double t_price, String t_state, int cId) {
        this.tId = tId;
        this.t_name = t_name;
        this.t_res = t_res;
        this.t_date = t_date;
        this.t_price = t_price;
        this.t_state = t_state;
        this.cId = cId;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public void setT_res(String t_res) {
        this.t_res = t_res;
    }

    public void setT_date(String t_date) {
        this.t_date = t_date;
    }

    public void setT_price(Double t_price) {
        this.t_price = t_price;
    }
    public void setT_state(String t_state) {
        this.t_state = t_state;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public int gettId() {
        return tId;
    }

    public String getT_name() {
        return t_name;
    }

    public String getT_res() {
        return t_res;
    }

    public String getT_date() {
        return t_date;
    }

    public Double getT_price() {
        return t_price;
    }

    public String getT_state() {
        return t_state;
    }



    @Override
    public String toString() {
        return "TaskParty{" +
                "tId=" + tId +
                ", t_name='" + t_name + '\'' +
                ", t_res='" + t_res + '\'' +
                ", t_date='" + t_date + '\'' +
                ", t_price=" + t_price +
                ", t_state='" + t_state + '\'' +
                ", cId=" + cId +
                '}';
    }
}