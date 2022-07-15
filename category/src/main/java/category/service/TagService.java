package category.service;

import category.data.Tag;
import category.data.Category;
import category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class TagService  {

    private final CategoryRepository categoryRepository;

    public TagService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void setCategory(Tag tag, String nameCategory)
    {
        tag.setCategory(categoryRepository.findCategoryByName(nameCategory));
    }

    public void updateTag(Tag tag, String nameCategory, String nameTag)
    {
        tag.setCategory(categoryRepository.findCategoryByName(nameCategory));
        tag.setName(nameTag);
    }

    public  void deleteCategory(Tag tag)
    {
        Category category = new Category();
        tag.setCategory(category);
    }
}
