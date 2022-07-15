package fr.gamedev.question.question.service;

import fr.gamedev.question.question.data.UserAnswer;
import org.springframework.stereotype.Service;

@Service
public class UserAnswerService {
    public void updateUserAnswerById(UserAnswer userAnswer, Integer points, boolean correctAnswer , String response)
    {
        userAnswer.setPoints(points);
        userAnswer.setCorrectAnswer(correctAnswer);
        userAnswer.setResponse(response);
    }
}
