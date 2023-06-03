package poller.skillContext.domain.repository;

import org.springframework.data.repository.query.Param;
import poller.skillContext.domain.model.Category;
import poller.skillContext.domain.model.Skill;
import poller.skillContext.domain.model.Tag;

public interface SkillRepository {

    Category GetCategories();
    Category GetCategoryById(@Param("id") long id);
    Category AddCategory(@Param("id") long id ,@Param("value") String value );
    Category DeleteCategoryById(@Param("id") long id);
    Category UpdateCategoryById(@Param("id") long id,@Param("value") String value);
    Tag GetTags();
    Tag GetTagById(@Param("id") long id);
    Tag AddTag(@Param("id") long id ,@Param("value") String value,@Param("category")Category category);
    Tag UpdateTagById(@Param("id") long id ,@Param("name") String name,@Param("category")Category category);
    Tag DeleteTagById(@Param("id") long id);
    Skill GetSkills();
    Skill AddSkill(@Param("name") long name , @Param("category")Category category, @Param("Tag")Tag tag );



/*- GetCategories(): List<Category>
- GetCategoryById(int id): Category
- AddCategory(int id, string value): Category
- DeleteById(int id): bool
- UpdateById(int id, string value): Category
*/

}
