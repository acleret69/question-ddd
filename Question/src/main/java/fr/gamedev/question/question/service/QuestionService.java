package fr.gamedev.question.question.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fr.gamedev.question.question.data.Question;
import fr.gamedev.question.question.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class QuestionService {
    /**The questionRepository.*/
    private final QuestionRepository questionRepository;

    /**QuestionService constructor.
     * @param questionRepository the questionRepository*/
    public QuestionService(final QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    /** setTag method.
     * @param question the question
     * @param nameTag the tag name*/
    public void setTag(final Question question, final String nameTag) {
        final String uri = "http://localhost:8080/tag/search/findTagsByName?name=";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri + nameTag, String.class);
        JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();

        System.out.println("question tag id : " + question.getIdTag());
        int id = Integer.parseInt(String.valueOf(jsonObject.get("id")));
        System.out.println("id from tag: " + id);

        question.setIdTag(id);
        System.out.println("question tag id : " + question.getIdTag());
    }

    /**
     * updateTag method.
     * @param question the question
     * @param content the content
     * @param correctAnswer the correct answer
     */
    public void updateTag(
            final Question question,
            final String content,
            final String correctAnswer) {
        question.setContent(content);
        question.setCorrectAnswer(correctAnswer);
    }

    /**
     * deleteTag method.
     * @param question the question
     */
    public  void deleteTag(
            final Question question) {
        question.setIdTag(0);
    }

    /**
     * findQuestionsByTag method.
     * @param tagName the tag name
     * @return a list of Question
     */
    public List<Question> findQuestionsByTag(
            final String tagName) {
        final String uri = "http://localhost:8080/tag/search/findTagsByName?name=";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri + tagName, String.class);
        JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();

        int idTag = Integer.parseInt(String.valueOf(jsonObject.get("id")));
        return questionRepository.findQuestionsByidTag(idTag);
    }
}
