package questionContext.domain.service.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import questionContext.domain.model.Question;

import java.util.List;

/**
 * QuestionService interface
 */
@Service
public interface QuestionService {

    /** setTag method.
     * @param question the question
     * @param nameTag the tag name*/
    public void setTag(final Question question, final String nameTag);

    /**
     * updateTag method.
     * @param question the question
     * @param content the content
     * @param correctAnswer the correct answer
     */
    public void updateTag(final Question question, final String content, final String correctAnswer);

    /**
     * deleteTag method.
     * @param question the question
     */
    public void deleteTag(final Question question);

    /**
     * findQuestionsByTag method.
     * @param tagName the tag name
     * @return a list of Question
     */
    public List<Question> findQuestionsByTag(final String tagName);
}
