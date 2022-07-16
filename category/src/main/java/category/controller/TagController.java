package category.controller;

import category.data.Tag;
import category.repository.TagRepository;
import category.service.TagService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

/**
 * TagController class.
 */
@RestController
public class TagController {
    /**
     * The tagService.
     */
    private final transient TagService tagService;
    /**
     * The tagRepository.
     */
    private final transient TagRepository tagRepository;

    /**
     * TagController constructor.
     * @param tagService a tagService
     * @param tagRepository a tagRepository
     */
    public TagController(final TagService tagService, final TagRepository tagRepository) {
        this.tagService = tagService;
        this.tagRepository = tagRepository;
    }

    /**
     * updateCategoryFromTag method.
     * @param tagId a tag ID
     * @param categoryName a category name
     */
    @PostMapping("/updateCategoryFromTag")
    public final void updateCategoryFromTag(@RequestParam final long tagId, @RequestParam final String categoryName) {
        final Tag tag = tagRepository.findTagsById(tagId);
        System.out.println("tag name : " + tag.getName());
        tagService.setCategory(tag, categoryName);
        System.out.println("category id :" + tag.getCategory().getId());
        tagRepository.save(tag);
    }

    /**
     * updateTag method.
     * @param tagId the tag ID
     * @param categoryName the category name
     * @param tagName the tag name
     */
    @PostMapping("/updateTag")
    public final void updateTag(
            @RequestParam final long tagId,
            @RequestParam final String categoryName,
            @RequestParam final String tagName) {
        final Tag tag = tagRepository.findTagsById(tagId);
        tagService.updateTag(tag, categoryName, tagName);
        tagRepository.save(tag);
    }

    /**
     * deleteCategoryFromTag method.
     * @param tagId the tag ID
     */
    @PostMapping("/deleteCategoryFromTag")
    public final void deleteCategoryFromTag(@RequestParam final long tagId) {
        final Tag tag = tagRepository.findTagsById(tagId);
        System.out.println("category id : " + tag.getCategory().getId());
        tagService.deleteCategory(tag);
        System.out.println("category name : " + tag.getCategory().getName());
        System.out.println("category id : " + tag.getCategory().getId());
        tagRepository.save(tag);
    }

    /**
     * deleteTagById method.
     * @param tagId the tag ID
     */
    @DeleteMapping("/deleteTagById")
    public final void deleteTagById(@RequestParam final long tagId) {
        tagRepository.deleteById(tagId);
    }
}
