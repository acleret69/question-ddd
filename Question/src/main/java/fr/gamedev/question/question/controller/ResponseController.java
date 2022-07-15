package fr.gamedev.question.question.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fr.gamedev.question.question.data.PendingResponse;
import fr.gamedev.question.question.data.Question;
import fr.gamedev.question.question.data.Status;
import fr.gamedev.question.question.data.UserAnswer;
import fr.gamedev.question.question.repository.PendingResponseRepository;
import fr.gamedev.question.question.repository.QuestionRepository;
import fr.gamedev.question.question.repository.UserAnswerRepository;
import fr.gamedev.question.question.service.PendingResponseService;
import fr.gamedev.question.question.service.QuestionService;
import fr.gamedev.question.question.service.UserAnswerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

/**
 * @author djer1
 *
 */
@RestController
public class ResponseController {

    private final QuestionService questionService;
    private final QuestionRepository questionRepository;
    private final UserAnswerService userAnswerService;
    private final UserAnswerRepository userAnswerRepository;
    private final PendingResponseRepository pendingResponseRepository ;
    private final PendingResponseService pendingResponseService;

    public ResponseController(final QuestionService questionService, final QuestionRepository questionRepository,
                              final UserAnswerService userAnswerService, final UserAnswerRepository userAnswerRepository,
                              final PendingResponseRepository pendingResponseRepository, final PendingResponseService pendingResponseService) {
        this.questionService = questionService;
        this.questionRepository = questionRepository;
        this.userAnswerService = userAnswerService;
        this.userAnswerRepository =userAnswerRepository;
        this.pendingResponseRepository=pendingResponseRepository;
        this.pendingResponseService = pendingResponseService;
    }

    @GetMapping("/response")
    public final String answer(@RequestParam final long questionId, @RequestParam final Boolean answer,
            @RequestParam final long userId) {
        String response;

        if (answer == Boolean.TRUE) {
// Ajouter des points

            response = "Bravo ! vous avez trouvé ! ";
        } else {
// Ne pas ajouter de points

            response = "Oops ! Ca n'est pas correcte";
        }
        return response;
    }

    @PostMapping("/updateTagFromQuestion")
    private void updateTagFromQuestion(@RequestParam final long questionId, @RequestParam final String nameTag) {
        Question question = questionRepository.findQuestionById(questionId);
        questionService.setTag(question, nameTag);
        questionRepository.save(question);
    }

    @PostMapping("/updateQuestionById")
    private void updateTagFromQuestion(@RequestParam final long questionId, @RequestParam final String content,@RequestParam final String correctAnswer) {
        Question question = questionRepository.findQuestionById(questionId);
        questionService.updateTag(question, content, correctAnswer);
        questionRepository.save(question);
    }

    @PostMapping("/updateUserAnswerById")
    private void updateUserAnswerById(@RequestParam final long userAnswerId, @RequestParam final Integer points,
                                      @RequestParam final boolean correctAnswer,@RequestParam final String response) {
        UserAnswer userAnswer = userAnswerRepository.findUserAnswerById(userAnswerId);
        userAnswerService.updateUserAnswerById(userAnswer, points, correctAnswer, response);
        userAnswerRepository.save(userAnswer);
    }

    @PostMapping("/updatePendingResponseAnswerById")
    private void updatePendingResponseAnswerById(@RequestParam final long userAnswerId, @RequestParam final Integer points,
                                      @RequestParam final boolean correctAnswer,@RequestParam final String response) {
        UserAnswer userAnswer = userAnswerRepository.findUserAnswerById(userAnswerId);
        userAnswerService.updateUserAnswerById(userAnswer, points, correctAnswer, response);
        userAnswerRepository.save(userAnswer);
    }

    @PostMapping("/deleteTagFromQuestion")
    private void deleteTagFromQuestion(@RequestParam final long questionId) {
        Question question = questionRepository.findQuestionById(questionId);
        questionService.deleteTag(question);
        questionRepository.save(question);
    }

    @DeleteMapping("/deleteQuestionById")
    public final void deleteTagById(@RequestParam final long idQuestion) {
        questionRepository.deleteById(idQuestion);
    }

    @DeleteMapping("/deleteUserAnswerById")
    public final void deleteUserAnswerById(@RequestParam final long userAnswerId) {
        questionRepository.deleteById(userAnswerId);
    }

    @GetMapping("/findQuestionByTagName")
    public final List<Question> findQuestionByTagName(@RequestParam final String tagName) {
        return questionService.findQuestionsByTag(tagName);
    }

    @PostMapping("/userAnswer")
    public final void userAnswer(@RequestParam final long Id, @RequestParam final long IdUser,
                                 @RequestParam final long IdQuestion, @RequestParam String response) {
        Question question = questionRepository.findQuestionById(IdQuestion);

        PendingResponse pending = pendingResponseService.checkUserPendingResponse(IdUser);
        if (pending.getStatus() == Status.waitingForAnwer && pending.getIdUser() == IdUser) {
            UserAnswer userAnswer = userAnswerRepository.findByIdUserAndIdQuestionAndResponse(IdUser, IdQuestion, "");
            userAnswer.setResponse(response);
            userAnswerService.setPoints(userAnswer, question, pending);
            userAnswerRepository.save(userAnswer);
            pendingResponseRepository.save(pending);
        } else {
            UserAnswer userAnswer = userAnswerService.initialiseUserAnswer(IdUser, IdQuestion, response);
            PendingResponse pendingResponse = pendingResponseService.initialiseUserAnswer(IdUser, IdQuestion);
            userAnswerService.setPoints(userAnswer, question, pendingResponse);
            userAnswerRepository.save(userAnswer);
            pendingResponseRepository.save(pendingResponse);
        }
    }

}
