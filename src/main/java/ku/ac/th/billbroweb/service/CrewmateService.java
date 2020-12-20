package ku.ac.th.billbroweb.service;

import ku.ac.th.billbroweb.model.Crewmate;
import ku.ac.th.billbroweb.model.TaskParty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CrewmateService {
    private RestTemplate restTemplate;

    public CrewmateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Crewmate> getCrewmateOfTaskParty(int id){
        String url = "http://localhost:8091/api/crewmate/task-party/" + id;
        ResponseEntity<Crewmate[]> responseEntity = restTemplate.getForEntity(
                url, Crewmate[].class);
        Crewmate[] crewmates = responseEntity.getBody();

        return Arrays.asList(crewmates);
    }

    public List<Crewmate> getCrewmate(){
        String url = "http://localhost:8091/api/crewmate";
        ResponseEntity<Crewmate[]> responseEntity = restTemplate.getForEntity(
                url, Crewmate[].class
        );
        Crewmate[] crewmates = responseEntity.getBody();
        return Arrays.asList(crewmates);
    }

    public void openCrewmate(Crewmate crewmate){
        String url = "http://localhost:8091/api/crewmate";
        restTemplate.postForEntity(url, crewmate, Crewmate.class);
    }

    public Crewmate getCrewmate(int id){
        String url = "http://localhost:8091/api/crewmate/" + id;
        ResponseEntity<Crewmate> responseEntity = restTemplate.getForEntity(
                url,Crewmate.class
        );
        return responseEntity.getBody();
    }

    public void editCrewmate(Crewmate crewmate){
        String url = "http://localhost:8091/api/crewmate/" + crewmate.getCm_id();
        restTemplate.put(url,crewmate);
    }

    public void  deleteCrewmate(Crewmate crewmate){
        String url = "http://localhost:8091/api/crewmate/" + crewmate.getCm_id();
        restTemplate.delete(url, crewmate);
    }
}
