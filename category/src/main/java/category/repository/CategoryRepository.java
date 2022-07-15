package category.repository;

import category.data.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author djer1
 *
 */
@RepositoryRestResource(collectionResourceRel = "category", path = "category")
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
    Category findCategoryByName(@Param("name") String name);
    Category findCategoryById(@Param("id") long id);
}
