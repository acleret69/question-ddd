package fr.gamedev.question.question.service;

import fr.gamedev.question.question.data.PendingResponse;
import fr.gamedev.question.question.data.Status;
import fr.gamedev.question.question.repository.PendingResponseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PendingResponseService class.
 */
@Service
public class PendingResponseService {
    /** The pendingResponseRepository.*/
    private final transient PendingResponseRepository pendingResponseRepository;

    /**The constructor of PendingResponseService.
     * @param pendingResponseRepository the pendingResponseRepository*/
    public PendingResponseService(final PendingResponseRepository pendingResponseRepository) {
        this.pendingResponseRepository = pendingResponseRepository;
    }

    /** initialiseUserAnswer method.
     * @param idUser the user ID
     * @param idQuestion the question ID
     * @return a pending response*/
    public PendingResponse initialiseUserAnswer(
            final long idUser,
            final long idQuestion) {
        final PendingResponse pendingResponse = new PendingResponse();

        pendingResponse.setIdQuestion(idQuestion);
        pendingResponse.setIdUser(idUser);
        pendingResponse.setStatus(Status.WAITING_FOR_ANSWER);

        return  pendingResponse;
    }

    /** checkUserPendingResponse method.
     * @param idUser the user ID
     * @return a pending response*/
    public PendingResponse checkUserPendingResponse(final long idUser) {
        try {
           final List<PendingResponse> pendingResponse = pendingResponseRepository.findPendingResponsesByIdUser(idUser);
           for (final PendingResponse pr : pendingResponse) {
               if (pr.getStatus() == Status.WAITING_FOR_ANSWER) {
                   return pr;
               }
           }
            return new PendingResponse();
        } catch (Exception e) {
            return new PendingResponse();
        }
    }


}
