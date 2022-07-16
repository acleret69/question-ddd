package fr.gamedev.question.question.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.gamedev.question.question.data.Question;

import java.util.List;

/**
 * QuestionRepository interface.
 */
@RepositoryRestResource(collectionResourceRel = "question", path = "question")
public interface QuestionRepository extends PagingAndSortingRepository<Question, Long> {
    /**
     * findQuestionById method.
     * @param id an ID
     * @return a question
     */
    Question findQuestionById(@Param("id") long id);

    /**
     * findQuestionsByidTag method.
     * @param idTag a tag ID
     * @return a list of Question
     */
    List<Question> findQuestionsByidTag(@Param("idTag") int idTag);
}
