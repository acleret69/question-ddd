/**
 */
package com.microservice.user.repository;

import com.microservice.user.data.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * UserRepository class.
 */
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    /**
     * findByLastName method.
     * @param lastName a lastname
     * @return a user
     */
    User findByLastName(@Param("lastName") String lastName);

    /**
     * findUserById method.
     * @param id an ID
     * @return a user
     */
    User findUserById(@Param("id") Long id);
}
