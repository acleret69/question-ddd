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

    private final QuestionRepository questionRepository;

    public QuestionService(final QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void setTag(Question question, String nameTag)
    {
        final String uri = "http://localhost:8080/tag/search/findTagsByName?name=";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri+nameTag, String.class);
        JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();

        System.out.println("question tag id : " + question.getIdTag());
        int id = Integer.parseInt(String.valueOf(jsonObject.get("id")));
        System.out.println("id from tag: "+ id);

        question.setIdTag(id);
        System.out.println("question tag id : " + question.getIdTag());
    }

    public void updateTag(Question question, String content, String correctAnswer)
    {
        question.setContent(content);
        question.setCorrectAnswer(correctAnswer);
    }

    public  void deleteTag(Question question)
    {
        question.setIdTag(0);
    }

    public List<Question> findQuestionsByTag (String tagName)
    {
        final String uri = "http://localhost:8080/tag/search/findTagsByName?name=";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri+tagName, String.class);
        JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();

        int idTag = Integer.parseInt(String.valueOf(jsonObject.get("id")));
        return questionRepository.findQuestionsByidTag(idTag);
    }

}
