package fr.gamedev.question.question.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.gamedev.question.question.data.Answer;

/**
 * @author djer1
 *
 */
@RepositoryRestResource(collectionResourceRel = "answer", path = "answer")
public interface AnswerRepository extends PagingAndSortingRepository<Answer, Long> {

}
