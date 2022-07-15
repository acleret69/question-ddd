package category.service;

import category.data.Category;
import category.data.Tag;
import category.repository.TagRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final TagRepository tagRepository;

    public CategoryService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public void setTag(Category category, String name)
    {
        Tag tag = tagRepository.findTagsByName(name);
        category.setIdTag(tag.getId());
    }

    public  void deleteTag(Category category)
    {
        category.setIdTag(0);
    }

}
