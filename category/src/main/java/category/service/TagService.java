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

    public void setCategory(Tag tag, String name)
    {

        tag.setCategory(categoryRepository.findCategoryByName(name));

    }

    public  void deleteCategory(Tag tag)
    {
        Category category = new Category();
        tag.setCategory(category);
    }
}
