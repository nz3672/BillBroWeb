package ku.ac.th.billbroweb.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Captain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int c_id;

    private String cUsername;
    private String c_pwd;
    private String c_name;
    private String c_email;

    public Captain() {
    }

    public Captain(int c_id, String cUsername, String c_pwd, String c_name, String c_email) {
        this.c_id = c_id;
        this.cUsername = cUsername;
        this.c_pwd = c_pwd;
        this.c_name = c_name;
        this.c_email = c_email;
    }

    public Captain(String cUsername, String c_pwd, String c_name, String c_email) {
        this.cUsername = cUsername;
        this.c_pwd = c_pwd;
        this.c_name = c_name;
        this.c_email = c_email;
    }

    public int getC_id() {
        return c_id;
    }

    public String getcUsername() {
        return cUsername;
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

    public void setcUsername(String cUsername) {
        this.cUsername = cUsername;
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
                ", cUsername='" + cUsername + '\'' +
                ", c_pwd='" + c_pwd + '\'' +
                ", c_name='" + c_name + '\'' +
                ", c_email='" + c_email + '\'' +
                '}';
    }

}
