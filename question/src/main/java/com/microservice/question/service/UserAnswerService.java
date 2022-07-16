package com.microservice.question.service;

import com.microservice.question.data.PendingResponse;
import com.microservice.question.data.Question;
import com.microservice.question.data.Status;
import com.microservice.question.data.UserAnswer;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * UserAnswerService class.
 */
@Service
public class UserAnswerService {
    /**
     * Constant for Correct Answer.
     */
    private static final int CORRECT_ANSWER_POINTS = 5;
    /**
     * Constant for Bad Answer.
     */
    private static final int BAD_ANSWER_POINTS = 0;

    /**
     * UserAnswerService constructor.
     */
    public UserAnswerService() { }

    /**
     * updateUserAnswerById method.
     * @param userAnswer a userAnswer
     * @param points a number of points
     * @param correctAnswer a correctAnswer
     * @param response a response
     */
    public void updateUserAnswerById(
            final UserAnswer userAnswer,
            final Integer points,
            final boolean correctAnswer,
            final String response) {
        userAnswer.setPoints(points);
        userAnswer.setCorrectAnswer(correctAnswer);
        userAnswer.setResponse(response);
    }

    /**
     * setPoints method.
     * @param userAnswer a userAnswer
     * @param question a question
     * @param pendingResponse a pendingResponse
     */
    public void setPoints(
            final UserAnswer userAnswer,
            final Question question,
            final PendingResponse pendingResponse) {
        if (userAnswer.getResponse() != null && !Objects.equals(userAnswer.getResponse(), "")) {
            if (Objects.equals(userAnswer.getResponse(), question.getCorrectAnswer())) {
                userAnswer.setCorrectAnswer(true);
                userAnswer.setPoints(CORRECT_ANSWER_POINTS);
            } else {
                userAnswer.setCorrectAnswer(false);
                userAnswer.setPoints(BAD_ANSWER_POINTS);
            }
            pendingResponse.setStatus(Status.ANSWERED);

        } else {
            userAnswer.setPoints(BAD_ANSWER_POINTS);
        }
    }

    /**
     * initialiseUserAnswer method.
     * @param idUser a user ID
     * @param idQuestion a question ID
     * @param response a response
     * @return a UserAnswer
     */
    public UserAnswer initialiseUserAnswer(
            final long idUser,
            final long idQuestion,
            final String response) {
        final UserAnswer userAnswer = new UserAnswer();
        userAnswer.setIdUser(idUser);
        userAnswer.setIdQuestion(idQuestion);
        userAnswer.setResponse(response);
        return  userAnswer;
    }

}
