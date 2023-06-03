package questionContext.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import questionContext.domain.model.UserAnswer;

/**
 * UserAnswerRepository interface.
 */
@RepositoryRestResource(collectionResourceRel = "usersAnswer", path = "usersAnswer")
public interface UserAnswerRepository extends PagingAndSortingRepository<UserAnswer, Long> {
    /**
     * findUserAnswerById method.
     * @param userAnswerId a user answer ID
     * @return a user answer
     */
    UserAnswer findUserAnswerById(long userAnswerId);

    /**
     * findByIdUserAndIdQuestionAndResponse method.
     * @param idUser a user id
     * @param idQuestion a question id
     * @param response a response
     * @return a user answer
     */
    UserAnswer findByIdUserAndIdQuestionAndResponse(@Param("idUser") long idUser, @Param("idQuestion") long idQuestion,
                                                               @Param("response") String response);
}
