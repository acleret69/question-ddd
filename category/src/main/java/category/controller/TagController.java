package category.controller;

import category.data.Tag;
import category.repository.TagRepository;
import category.service.TagService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
public class TagController {
    /**
     * The tagService.
     */
    private final TagService tagService;
    /**
     * The tagRepository.
     */
    private final TagRepository tagRepository;

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
     * updateCategorieFromTag method.
     * @param idTag a tag ID
     * @param nameCategorie a category name
     */
    @PostMapping("/updateCategorieFromTag")
    public final void updateCategorieFromTag(@RequestParam final long idTag, @RequestParam final String nameCategorie) {
        Tag tag = tagRepository.findTagsById(idTag);
        System.out.println("tag name : " + tag.getName());
        tagService.setCategory(tag, nameCategorie);
        System.out.println("category id :" + tag.getCategory().getId());
        tagRepository.save(tag);
    }

    /**
     * updateTag method.
     * @param idTag the tag ID
     * @param nameCategorie the category name
     * @param nameTag the tag name
     */
    @PostMapping("/updateTag")
    public final void updateTag(
            @RequestParam final long idTag,
            @RequestParam final String nameCategorie,
            @RequestParam final String nameTag) {
        Tag tag = tagRepository.findTagsById(idTag);
        tagService.updateTag(tag, nameCategorie, nameTag);
        tagRepository.save(tag);
    }

    /**
     * deleteCategorieFromTag method.
     * @param idTag the tag ID
     */
    @PostMapping("/deleteCategorieFromTag")
    public final void deleteCategorieFromTag(@RequestParam final long idTag) {
        Tag tag = tagRepository.findTagsById(idTag);
        System.out.println("category id : " + tag.getCategory().getId());
        tagService.deleteCategory(tag);
        System.out.println("category name : " + tag.getCategory().getname());
        System.out.println("category id : " + tag.getCategory().getId());
        tagRepository.save(tag);
    }

    /**
     * deleteTagById method.
     * @param idTag the tag ID
     */
    @DeleteMapping("/deleteTagById")
    public final void deleteTagById(@RequestParam final long idTag) {
        tagRepository.deleteById(idTag);
    }

}
