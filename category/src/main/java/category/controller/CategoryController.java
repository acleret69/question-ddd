package category.controller;

import category.data.Category;
import category.repository.CategoryRepository;
import category.service.CategoryService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;

/**
 * @author djer1
 *
 */
@RestController
public class CategoryController {
    /** The category service.
     */
    private final transient CategoryService categoryService;
    /** The category repository.
     */
    private final transient CategoryRepository categoryRepository;

    /** Constructor of CategoryController.
     * @param categoryService the category service
     * @param categoryRepository the category repository
     * */
    public CategoryController(
            final CategoryService categoryService,
            final CategoryRepository categoryRepository) {
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }

    /** updateTagFromCategorie method.
     * @param idCategory the category ID
     * @param nameTag the tag name
     */
    @PostMapping("/updateTagFromCategorie")
    public final void updateTagFromCategorie(
            @RequestParam final long idCategory,
            @RequestParam final String nameTag) {
        final Category category = categoryRepository.findCategoryById(idCategory);
        System.out.println(category.getname());
        categoryService.setTag(category, nameTag);
        System.out.println(category.getIdTag());
        System.out.println(category.getname());
        categoryRepository.save(category);
    }

    /** deleteTagFromCategorie method.
     * @param idCategory the category ID
     */
    @PostMapping("/deleteTagFromCategorie")
    public final void deleteTagFromCategorie(
            @RequestParam final long idCategory) {
        final Category category = categoryRepository.findCategoryById(idCategory);
        System.out.println(category.getname());
        System.out.println(category.getIdTag());
        categoryService.deleteTag(category);
        System.out.println(category.getIdTag());
        categoryRepository.save(category);
    }

    /** updateCategorie method.
     * @param idCategory the category Id
     * @param nameTag the tag name
     * @param valueCategory the category value
     */
    @PostMapping("/updateCategorie")
    public final void updateCategorie(
            @RequestParam final long idCategory,
            @RequestParam final String nameTag,
            @RequestParam final String valueCategory) {
        final Category category = categoryRepository.findCategoryById(idCategory);
        categoryService.updateCategory(category, nameTag, valueCategory);
        categoryRepository.save(category);
    }

    /** deleteTagById method.
     * @param idCategory the category Id
     */
    @DeleteMapping("/deleteCategoryById")
    public final void deleteTagById(@RequestParam final long idCategory) {
        categoryRepository.deleteById(idCategory);
    }

}
