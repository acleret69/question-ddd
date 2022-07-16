package category.service;

import category.data.Tag;
import category.data.Category;
import category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class TagService  {

    /**
     * The categoryRepository.
     */
    private final CategoryRepository categoryRepository;

    /**
     * TagService constructor.
     * @param categoryRepository a categoryRepository
     */
    public TagService(
            final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * setCategory method.
     * @param tag a tag
     * @param nameCategory a category name
     */
    public void setCategory(
            final Tag tag,
            final String nameCategory) {
        tag.setCategory(categoryRepository.findCategoryByName(nameCategory));
    }

    /**
     * updateTag method.
     * @param tag a tag
     * @param nameCategory a category name
     * @param nameTag a tag name
     */
    public void updateTag(
            final Tag tag,
            final String nameCategory,
            final String nameTag) {
        tag.setCategory(categoryRepository.findCategoryByName(nameCategory));
        tag.setName(nameTag);
    }

    /**
     * deleteCategory method.
     * @param tag a tag
     */
    public  void deleteCategory(final Tag tag) {
        Category category = new Category();
        tag.setCategory(category);
    }
}
