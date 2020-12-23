package ku.ac.th.billbroweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Crewmate {


    private int cm_id;

    private String cm_name;
    private String cm_email;
    private Double cm_per_price;
    private String cm_state;
    private int tId;

    public void setCm_id(int cm_id) {
        this.cm_id = cm_id;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public Crewmate() {
    }

    public Crewmate(int cm_id, String cm_name, String cm_email, Double cm_per_price, String cm_state) {
        this.cm_id = cm_id;
        this.cm_name = cm_name;
        this.cm_email = cm_email;
        this.cm_per_price = cm_per_price;
        this.cm_state = cm_state;
    }

    public void setCm_name(String cm_name) {
        this.cm_name = cm_name;
    }

    public void setCm_email(String cm_email) {
        this.cm_email = cm_email;
    }

    public void setCm_per_price(Double cm_per_price) {
        this.cm_per_price = cm_per_price;
    }

    public void setCm_state(String cm_state) {
        this.cm_state = cm_state;
    }

    public int getCm_id() {
        return cm_id;
    }

    public String getCm_name() {
        return cm_name;
    }

    public String getCm_email() {
        return cm_email;
    }

    public Double getCm_per_price() {
        return cm_per_price;
    }

    public String getCm_state() {
        return cm_state;
    }

    @Override
    public String toString() {
        return "Crewmate{" +
                "cm_id=" + cm_id +
                ", cm_name='" + cm_name + '\'' +
                ", cm_email='" + cm_email + '\'' +
                ", cm_per_price=" + cm_per_price +
                ", cm_state='" + cm_state + '\'' +
                '}';
    }
}
