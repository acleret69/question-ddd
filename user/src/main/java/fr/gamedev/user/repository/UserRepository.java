/**
 */
package fr.gamedev.user.repository;

import java.util.List;

import fr.gamedev.user.data.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author djer1
 *
 */
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
User findByLastName(@Param("lastName") String lastName);
User findUserById(@Param("id") Long id);
}
