package fr.gamedev.question.question.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fr.gamedev.question.question.data.PendingResponse;
import fr.gamedev.question.question.data.Status;
import fr.gamedev.question.question.repository.PendingResponseRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PendingResponseService {

    private final PendingResponseRepository pendingResponseRepository;

    public PendingResponseService(final PendingResponseRepository pendingResponseRepository) {
        this.pendingResponseRepository = pendingResponseRepository;
    }


    public PendingResponse initialiseUserAnswer(long idUser, long idQuestion) {
        PendingResponse pendingResponse = new PendingResponse();

        pendingResponse.setIdQuestion(idQuestion);
        pendingResponse.setIdUser(idUser);
        pendingResponse.setStatus(Status.waitingForAnwer);

        return  pendingResponse;
    }

    public PendingResponse checkUserPendingResponse(long idUser) {
        try {
           List<PendingResponse> pendingResponse = pendingResponseRepository.findPendingResponsesByIdUser(idUser);
           for (PendingResponse pr : pendingResponse) {
               if (pr.getStatus() == Status.waitingForAnwer) {
                   return pr;
               }
           }
            return new PendingResponse();
            //final String uri = "http://localhost:8081/findPendingResponsesByIdUser?idUser=";

           /* RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(uri + idUser, String.class);
            result = result.replace("[", "").replace("]", "");
            JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();
            System.out.println(jsonObject);
            return new PendingResponse();*/

        } catch (Exception e) {
            return new PendingResponse();
        }
    }


}
