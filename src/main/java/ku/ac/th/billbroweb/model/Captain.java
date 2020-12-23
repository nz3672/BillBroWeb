package ku.ac.th.billbroweb.model;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.Instant;


@Entity
public class Captain{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int c_id;

    @NotBlank(message = "Username is require")
    private String cUsername;
    @NotBlank(message = "Password is require")
    private String c_pwd;
    @NotBlank(message = "Name is require")
    private String c_name;
    @Email
    @NotBlank(message = "Email is require")
    private String c_email;

    private Instant created;
    private boolean enable;

    public Captain() {
    }

    public Captain(int c_id, @NotBlank(message = "Username is require") String cUsername, @NotBlank(message = "Password is require") String c_pwd, @NotBlank(message = "Name is require") String c_name, @Email @NotBlank(message = "Email is require") String c_email) {
        this.c_id = c_id;
        this.cUsername = cUsername;
        this.c_pwd = c_pwd;
        this.c_name = c_name;
        this.c_email = c_email;
    }

    public Captain(@NotBlank(message = "Username is require") String cUsername, @NotBlank(message = "Password is require") String c_pwd, @NotBlank(message = "Name is require") String c_name, @Email @NotBlank(message = "Email is require") String c_email) {
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

    public Instant getCreated() {
        return created;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
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
