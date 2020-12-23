package ku.ac.th.billbroweb.playload.request;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank(message = "Username is require")
    private String cUsername;
    @NotBlank(message = "Password is require")
    private String c_pwd;

    public LoginRequest(String username, String pwd) {
        this.cUsername = username;
        this.c_pwd = pwd;
    }

    public LoginRequest() {
    }

    public String getcUsername() {
        return cUsername;
    }

    public String getC_pwd() {
        return c_pwd;
    }

    public void setcUsername(String cUsername) {
        this.cUsername = cUsername;
    }

    public void setC_pwd(String c_pwd) {
        this.c_pwd = c_pwd;
    }
}
