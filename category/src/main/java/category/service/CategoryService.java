package category.service;

import category.data.Category;
import category.data.Tag;
import category.repository.TagRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    /** Tag Repository. */
    private final TagRepository tagRepository;

    /** CategoryService constructor.
     * @param tagRepository the tag repository
     */
    public CategoryService(final TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    /** Tag setter.
     * @param category the tag category
     * @param name the tag name */
    public void setTag(final Category category, final String name) {
        Tag tag = tagRepository.findTagsByName(name);
        category.setIdTag(tag.getId());
    }

    /** updateCategory method.
     * @param category the category
     * @param name the tag name
     * @param valueCategorie the category value*/
    public void updateCategory(
            final Category category,
            final String name,
            final String valueCategorie) {
        Tag tag = tagRepository.findTagsByName(name);
        category.setIdTag(tag.getId());
        category.setValue(valueCategorie);
    }

    /** deleteTag method.
     * @param category the category*/
    public void deleteTag(final Category category) {
        category.setIdTag(0);
    }
}
