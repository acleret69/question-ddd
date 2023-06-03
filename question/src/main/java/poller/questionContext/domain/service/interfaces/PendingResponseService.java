package poller.questionContext.domain.service.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poller.questionContext.domain.model.PendingResponse;

/**
 * PendingResponseService interface
 */

public interface PendingResponseService {
    /**
     * initialiseUserAnswer method.
     *
     * @param idUser     the user ID
     * @param idQuestion the question ID
     * @return a pending response
     */
    public PendingResponse initialiseUserAnswer(final long idUser, final long idQuestion);

    /**
     * checkUserPendingResponse method.
     *
     * @param idUser the user ID
     * @return a pending response
     */
    public PendingResponse checkUserPendingResponse(final long idUser);
}
