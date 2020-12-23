package ku.ac.th.billbroweb.service;

import ku.ac.th.billbroweb.model.Crewmate;
import ku.ac.th.billbroweb.model.HistoryPay;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class HistoryPayService {
    private RestTemplate restTemplate;

    public HistoryPayService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<HistoryPay> getHistoryPayOfCrewmate(int id){
        String url = "http://localhost:8091/api/history-pay/crewmate/" + id;
        ResponseEntity<HistoryPay[]> responseEntity = restTemplate.getForEntity(
                url, HistoryPay[].class);
        HistoryPay[] historyPays = responseEntity.getBody();

        return Arrays.asList(historyPays);
    }

    public List<HistoryPay> getHistoryPay(){
        String url = "http://localhost:8091/api/history-pay";
        ResponseEntity<HistoryPay[]> responseEntity = restTemplate.getForEntity(
                url, HistoryPay[].class
        );
        HistoryPay[] historyPays = responseEntity.getBody();
        return Arrays.asList(historyPays);
    }

    public void openHistoryPay(HistoryPay historyPay){
        String url = "http://localhost:8091/api/history-pay";
        restTemplate.postForEntity(url, historyPay, HistoryPay.class);
    }

    public HistoryPay getHistoryPay(int id){
        String url = "http://localhost:8091/api/history-pay/" + id;
        ResponseEntity<HistoryPay> responseEntity = restTemplate.getForEntity(
                url,HistoryPay.class
        );
        return responseEntity.getBody();
    }

    public void editHistoryPay(HistoryPay historyPay){
        String url = "http://localhost:8091/api/crewmate/" + historyPay.getHpId();
        restTemplate.put(url,historyPay);
    }

    public void  deleteHistoryPay(HistoryPay historyPay){
        String url = "http://localhost:8091/api/history-pay/" + historyPay.getHpId();
        restTemplate.delete(url, historyPay);
    }
}
