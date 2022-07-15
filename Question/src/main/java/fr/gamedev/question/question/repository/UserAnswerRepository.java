package fr.gamedev.question.question.repository;

import fr.gamedev.question.question.data.PendingResponse;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.gamedev.question.question.data.UserAnswer;

import java.util.List;

/**
 * @author djer13
 *
 */
@RepositoryRestResource(collectionResourceRel = "usersAnswer", path = "usersAnswer")
public interface UserAnswerRepository extends PagingAndSortingRepository<UserAnswer, Long> {
    UserAnswer findUserAnswerById(long userAnswerId);
    UserAnswer findByIdUserAndIdQuestionAndResponse(@Param("idUser") long idUser, @Param("idQuestion") long idQuestion,
                                                               @Param("response") String response);
}
