package ku.ac.th.billbroweb.service;

import ku.ac.th.billbroweb.data.CaptainRepository;
import ku.ac.th.billbroweb.model.Captain;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CaptainService {
    private CaptainRepository repository;

    private String hash(String pin){
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(pin, salt); // process hash
    }

    public CaptainService(CaptainRepository captainService) {
        this.repository = captainService;
    }

    public void createCaptain(Captain captain){
        String hashPin = hash(captain.getC_pwd());
        captain.setC_pwd(hashPin);
        repository.save(captain);
    }

    public List<Captain> getCaptain(){
        return repository.findAll();
    }

    public  Captain findCaptain(String username) {
        try {
            return repository.findBycUsername(username).get(0);
        } catch (NoSuchElementException e ){
            return null;
        }
    }

    public Captain checkPin(Captain inputCaptain){
        Captain storedCaptain = findCaptain(inputCaptain.getcUsername());
        if (storedCaptain != null) {
            String storedPin = storedCaptain.getC_pwd();
            if (BCrypt.checkpw(inputCaptain.getC_pwd(), storedPin)){
                return storedCaptain;
            }
        }
        return null;
    }
}
