package ku.ac.th.billbroweb.service;

import ku.ac.th.billbroweb.data.CaptainRepository;
import ku.ac.th.billbroweb.model.Captain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class CaptainDetailsService implements UserDetailsService {
    @Autowired
    private CaptainRepository captainRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Captain captain = captainRepository.findBycUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("No User Found" + s));
        return new org.springframework.security.core.userdetails
                .User(captain.getcUsername(), captain.getC_pwd(),
                true,true,true,true
                , getAuthorities("ROLE_USER"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role_user) {
        return Collections.singleton(new SimpleGrantedAuthority(role_user));
    }
}
