package ku.ac.th.billbroweb.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Captain {

    @Id
    private int c_id;

    private String c_username;
    private String c_pwd;
    private String c_name;
    private String c_email;

    public Captain() {
    }

    public Captain(int c_id, String c_username, String c_pwd, String c_name, String c_email) {
        this.c_id = c_id;
        this.c_username = c_username;
        this.c_pwd = c_pwd;
        this.c_name = c_name;
        this.c_email = c_email;
    }

    public int getC_id() {
        return c_id;
    }

    public String getC_username() {
        return c_username;
    }

    public String getC_pwd() {
        return c_pwd;
    }

    public String getC_name() {
        return c_name;
    }

    public String getC_email() {
        return c_email;
    }

    public void setC_pwd(String c_pwd) {
        this.c_pwd = c_pwd;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public void setC_email(String c_email) {
        this.c_email = c_email;
    }

    @Override
    public String toString() {
        return "Captain{" +
                "c_id=" + c_id +
                ", c_username='" + c_username + '\'' +
                ", c_pwd='" + c_pwd + '\'' +
                ", c_name='" + c_name + '\'' +
                ", c_email='" + c_email + '\'' +
                '}';
    }
}
