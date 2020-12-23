package ku.ac.th.billbroweb.service;

import ku.ac.th.billbroweb.data.CaptainRepository;
import ku.ac.th.billbroweb.model.Captain;
import ku.ac.th.billbroweb.playload.request.LoginRequest;
import ku.ac.th.billbroweb.playload.request.RegisterRequest;
import ku.ac.th.billbroweb.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuthService {
    @Autowired
    private CaptainRepository captainRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;

    public void signup(RegisterRequest registerRequest){
        Captain captain = new Captain();
        captain.setcUsername(registerRequest.getcUsername());
        captain.setC_pwd(encodePassword(registerRequest.getC_pwd()));
        captain.setC_name(registerRequest.getC_name());
        captain.setC_email(registerRequest.getC_email());
        captain.setCreated(Instant.now());
        captain.setEnable(true);

        captainRepository.save(captain);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public String login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getcUsername()
                        , loginRequest.getC_pwd()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtProvider.generateToken(authentication);
    }
}
