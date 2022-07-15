package fr.gamedev.question.question.controller;

import fr.gamedev.question.question.data.Question;
import fr.gamedev.question.question.data.UserAnswer;
import fr.gamedev.question.question.repository.QuestionRepository;
import fr.gamedev.question.question.repository.UserAnswerRepository;
import fr.gamedev.question.question.service.QuestionService;
import fr.gamedev.question.question.service.UserAnswerService;
import org.springframework.web.bind.annotation.*;

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

    public ResponseController(final QuestionService questionService, final QuestionRepository questionRepository,
                              final UserAnswerService userAnswerService, UserAnswerRepository userAnswerRepository) {
        this.questionService = questionService;
        this.questionRepository = questionRepository;
        this.userAnswerService = userAnswerService;
        this.userAnswerRepository =userAnswerRepository;
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
    private void updateTagFromQuestion(@RequestParam final long questionId, @RequestParam final String nameTag)
    {
        Question question = questionRepository.findQuestionById(questionId);
        questionService.setTag(question, nameTag);
        questionRepository.save(question);
    }

    @PostMapping("/updateQuestionById")
    private void updateTagFromQuestion(@RequestParam final long questionId, @RequestParam final String content,@RequestParam final String correctAnswer)
    {
        Question question = questionRepository.findQuestionById(questionId);
        questionService.updateTag(question,content,correctAnswer);
        questionRepository.save(question);
    }

    @PostMapping("/updateUserAnswerById")
    private void updateUserAnswerById(@RequestParam final long userAnswerId, @RequestParam final Integer points,
                                      @RequestParam final boolean correctAnswer,@RequestParam final String response)
    {
        UserAnswer userAnswer = userAnswerRepository.findUserAnswerById(userAnswerId);
        userAnswerService.updateUserAnswerById(userAnswer,points,correctAnswer,response);
        userAnswerRepository.save(userAnswer);
    }

    @PostMapping("/deleteTagFromQuestion")
    private void deleteTagFromQuestion(@RequestParam final long questionId)
    {
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

}
