package fr.gamedev.question.question.service;

import fr.gamedev.question.question.data.PendingResponse;
import fr.gamedev.question.question.data.Question;
import fr.gamedev.question.question.data.Status;
import fr.gamedev.question.question.data.UserAnswer;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserAnswerService {

    public void updateUserAnswerById(UserAnswer userAnswer, Integer points, boolean correctAnswer , String response) {
        userAnswer.setPoints(points);
        userAnswer.setCorrectAnswer(correctAnswer);
        userAnswer.setResponse(response);
    }

    public void setPoints(UserAnswer userAnswer, Question question, PendingResponse pendingResponse) {
        if (userAnswer.getResponse() != null && !Objects.equals(userAnswer.getResponse(), "")) {
            if(Objects.equals(userAnswer.getResponse(), question.getCorrectAnswer())) {
                userAnswer.setCorrectAnswer(true);
                userAnswer.setPoints(5);
            } else {
                userAnswer.setCorrectAnswer(false);
                userAnswer.setPoints(0);
            }
            pendingResponse.setStatus(Status.answered);

        }
    }



    public UserAnswer initialiseUserAnswer(long IdUser, long IdQuestion, String response) {
        UserAnswer userAnswer = new UserAnswer();
        //userAnswser.setId();
        userAnswer.setIdUser(IdUser);
        userAnswer.setIdQuestion(IdQuestion);
        userAnswer.setResponse(response);
        return  userAnswer;
    }

}
