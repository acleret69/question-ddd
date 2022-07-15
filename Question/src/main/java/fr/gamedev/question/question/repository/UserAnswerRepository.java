package fr.gamedev.question.question.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.gamedev.question.question.data.UserAnswer;

/**
 * @author djer13
 *
 */
@RepositoryRestResource(collectionResourceRel = "usersAnswer", path = "usersAnswer")
public interface UserAnswerRepository extends PagingAndSortingRepository<UserAnswer, Long> {

}
