package ku.ac.th.billbroweb.playload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class RegisterRequest {

    @NotBlank(message = "Username is require")
    private String cUsername;
    @NotBlank(message = "Password is require")
    private String c_pwd;
    @NotBlank(message = "Name is require")
    private String c_name;
    @Email
    @NotBlank(message = "Email is require")
    private String c_email;

    public RegisterRequest(String username, String pwd, String name, String email) {
        this.cUsername = username;
        this.c_pwd = pwd;
        this.c_name = name;
        this.c_email = email;
    }

    public RegisterRequest() {
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
}
