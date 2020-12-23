package ku.ac.th.billbroweb.service;
import ku.ac.th.billbroweb.model.TaskParty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TaskPartyService {
    private RestTemplate restTemplate;

    public TaskPartyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<TaskParty> getCaptainOfTaskParty(int id){
        String url = "http://localhost:8091/api/task-party/captain/" + id;
        ResponseEntity<TaskParty[]> responseEntity = restTemplate.getForEntity(
                url, TaskParty[].class);
        TaskParty[] taskParties = responseEntity.getBody();

        return Arrays.asList(taskParties);
    }

    public List<TaskParty> getTaskParty(){
        String url = "http://localhost:8091/api/task-party";
        ResponseEntity<TaskParty[]> responseEntity = restTemplate.getForEntity(
                url, TaskParty[].class
        );
        TaskParty[] taskParties = responseEntity.getBody();
        return Arrays.asList(taskParties);
    }

    public void openTaskParty(TaskParty taskParty){
        String url = "http://localhost:8091/api/task-party";
        restTemplate.postForEntity(url, taskParty, TaskParty.class);
    }

    public TaskParty getTaskParty(int id){
        String url = "http://localhost:8091/api/task-party/" + id;
        ResponseEntity<TaskParty> responseEntity = restTemplate.getForEntity(
                url,TaskParty.class
        );
        return responseEntity.getBody();
    }

    public void editTaskParty(TaskParty taskParty){
        String url = "http://localhost:8091/api/task-party/" + taskParty.gettId();
        restTemplate.put(url,taskParty);
    }

    public void  deleteTaskParty(TaskParty taskParty){
        String url = "http://localhost:8091/api/task-party/" + taskParty.gettId();
        restTemplate.delete(url, taskParty);
    }
}
