package category.repository;

import category.data.Tag;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * TagRepository interface.
 */
@RepositoryRestResource(collectionResourceRel = "tag", path = "tag")
public interface TagRepository extends PagingAndSortingRepository<Tag, Long> {
    /**
     * findTagsByName method.
     * @param name a tag name
     * @return a tag
     */
    Tag findTagsByName(@Param("name") String name);

    /**
     * findTagsById method.
     * @param id an ID
     * @return a tag
     */
    Tag findTagsById(@Param("id") long id);
}
