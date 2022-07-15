package fr.gamedev.question.question.service;

import fr.gamedev.question.question.data.PendingResponse;
import fr.gamedev.question.question.data.Status;
import org.springframework.stereotype.Service;

@Service
public class PendingResponseService {

    public PendingResponse initialiseUserAnswer(Long IdUser, long IdQuestion)
    {
        PendingResponse pendingResponse = new PendingResponse();

        pendingResponse.setIdQuestion(IdQuestion);
        pendingResponse.setIdUser(IdUser);
        pendingResponse.setStatus(Status.waitingForAnwer);

        return  pendingResponse;
    }

}
