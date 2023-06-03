package questionContext.domain.service.interfaces;

import org.springframework.stereotype.Service;
import questionContext.domain.model.PendingResponse;
import questionContext.domain.model.Question;
import questionContext.domain.model.UserAnswer;

/**
 * UserAnswerService interface
 */
@Service
public interface UserAnswerService {

    /**
     * updateUserAnswerById method.
     *
     * @param userAnswer    a userAnswer
     * @param points        a number of points
     * @param correctAnswer a correctAnswer
     * @param response      a response
     */
    public void updateUserAnswerById(
            final UserAnswer userAnswer,
            final Integer points,
            final boolean correctAnswer,
            final String response);

    /**
     * setPoints method.
     *
     * @param userAnswer      a userAnswer
     * @param question        a question
     * @param pendingResponse a pendingResponse
     */
    public void setPoints(final UserAnswer userAnswer, final Question question, final PendingResponse pendingResponse);

    /**
     * initialiseUserAnswer method.
     * @param idUser a user ID
     * @param idQuestion a question ID
     * @param response a response
     * @return a UserAnswer
     */
    public UserAnswer initialiseUserAnswer(final long idUser, final long idQuestion, final String response);
}
