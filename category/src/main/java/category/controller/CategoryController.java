package category.controller;

import category.data.Category;
import category.repository.CategoryRepository;
import category.service.CategoryService;
import org.springframework.web.bind.annotation.*;

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
        categoryRepository.save(category);
    }

    @PostMapping("/deleteTagFromCategorie")
    public final void deleteTagFromCategorie(@RequestParam final long idCategory) {
        Category category = categoryRepository.findCategoryById(idCategory);
        System.out.println(category.getname());
        System.out.println(category.getIdTag());
        categoryService.deleteTag(category);
        System.out.println(category.getIdTag());
        categoryRepository.save(category);
    }

    @PostMapping("/updateCategorie")
    public final void updateCategorie(@RequestParam final long idCategory, @RequestParam final String nameTag, @RequestParam final String valueCategory) {
        Category category = categoryRepository.findCategoryById(idCategory);
        categoryService.updateCategory(category, nameTag, valueCategory);
        categoryRepository.save(category);
    }

    @DeleteMapping("/deleteCategoryById")
    public final void deleteTagById(@RequestParam final long idCategory) {
        categoryRepository.deleteById(idCategory);
    }

}
