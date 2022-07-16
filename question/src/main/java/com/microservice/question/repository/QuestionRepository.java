package com.microservice.question.repository;

import com.microservice.question.data.Question;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * QuestionRepository interface.
 */
@RepositoryRestResource(collectionResourceRel = "com/microservice/question", path = "com/microservice/question")
public interface QuestionRepository extends PagingAndSortingRepository<Question, Long> {
    /**
     * findQuestionById method.
     * @param id an ID
     * @return a question
     */
    Question findQuestionById(@Param("id") long id);

    /**
     * findQuestionsByIdTag method.
     * @param idTag a tag ID
     * @return a list of Question
     */
    List<Question> findQuestionsByIdTag(@Param("idTag") int idTag);
}
