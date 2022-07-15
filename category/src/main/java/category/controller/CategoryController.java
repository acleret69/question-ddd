package category.controller;

import category.data.Category;
import category.repository.CategoryRepository;
import category.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author djer1
 *
 */
@RestController
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;

    public CategoryController(final CategoryService categoryService, final CategoryRepository categoryRepository) {
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/updateTagFromCategorie")
    public final void updateTagFromCategorie(@RequestParam final long idCategory, @RequestParam final String nameTag) {
        Category category = categoryRepository.findCategoryById(idCategory);
        System.out.println(category.getname());
        categoryService.setTag(category, nameTag);
        System.out.println(category.getIdTag());
        System.out.println(category.getname());
    }

    @PostMapping("/deleteTagFromCategorie")
    public final void deleteTagFromCategorie(@RequestParam final long idCategory) {
        Category category = categoryRepository.findCategoryById(idCategory);
        System.out.println(category.getname());
        System.out.println(category.getIdTag());
        categoryService.deleteTag(category);
        System.out.println(category.getIdTag());
    }

}
