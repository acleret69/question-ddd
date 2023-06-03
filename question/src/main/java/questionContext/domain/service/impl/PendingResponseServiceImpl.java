package questionContext.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import questionContext.domain.model.PendingResponse;
import questionContext.domain.model.Status;
import questionContext.domain.repository.PendingResponseRepository;
import questionContext.domain.service.interfaces.PendingResponseService;

import java.util.List;

/**
 * PendingResponseService class.
 */
@Service
public class PendingResponseServiceImpl implements PendingResponseService {
    /** The pendingResponseRepository.*/
    private final transient PendingResponseRepository pendingResponseRepository;

    /**The constructor of PendingResponseService.
     * @param pendingResponseRepository the pendingResponseRepository*/
    public PendingResponseServiceImpl(final PendingResponseRepository pendingResponseRepository) {
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
