package ku.ac.th.billbroweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskParty {

    private int t_id;

    private String t_name;
    private String t_res;
    private String t_date;
    private Double t_price;
    private String t_pic;
    private String t_state;
    private String t_email;

    public TaskParty() {
    }

    public TaskParty(int t_id, String t_name, String t_res, String t_date, Double t_price, String t_pic, String t_state,String email) {
        this.t_id = t_id;
        this.t_name = t_name;
        this.t_res = t_res;
        this.t_date = t_date;
        this.t_price = t_price;
        this.t_pic = t_pic;
        this.t_state = t_state;
        this.t_email = email;
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

    public void setT_pic(String t_pic) {
        this.t_pic = t_pic;
    }

    public void setT_state(String t_state) {
        this.t_state = t_state;
    }

    public int getT_id() {
        return t_id;
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

    public String getT_pic() {
        return t_pic;
    }

    public String getT_state() {
        return t_state;
    }

    public String getT_email() {
        return t_email;
    }

    public void setT_email(String t_email) {
        this.t_email = t_email;
    }

    @Override
    public String toString() {
        return "TaskParty{" +
                "t_id=" + t_id +
                ", t_name='" + t_name + '\'' +
                ", t_res='" + t_res + '\'' +
                ", t_date='" + t_date + '\'' +
                ", t_price='" + t_price + '\'' +
                ", t_pic='" + t_pic + '\'' +
                ", t_state='" + t_state + '\'' +
                '}';
    }
}
