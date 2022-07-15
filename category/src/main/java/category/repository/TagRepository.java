package category.repository;

import category.data.Tag;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author djer1
 *
 */
@RepositoryRestResource(collectionResourceRel = "tag", path = "tag")
public interface TagRepository extends PagingAndSortingRepository<Tag, Long> {
    Tag findTagsByName(@Param("name") String name);
    Tag findTagsById(@Param("id") long id);
}
