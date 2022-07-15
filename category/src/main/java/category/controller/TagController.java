package category.controller;

import category.data.Tag;
import category.repository.TagRepository;
import category.service.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {

    private final TagService tagService;
    private final TagRepository tagRepository;

    public TagController(final TagService tagService, final TagRepository tagRepository) {
        this.tagService = tagService;
        this.tagRepository = tagRepository;
    }

    @PostMapping("/updateCategorieFromTag")
    public final void updateCategorieFromTag(@RequestParam final long idTag, @RequestParam final String nameCategorie) {
        Tag tag = tagRepository.findTagsById(idTag);
        System.out.println("tag name : " + tag.getName());
        tagService.setCategory(tag, nameCategorie);
        System.out.println("category id :" + tag.getCategory().getId());
    }

    @PostMapping("/deleteCategorieFromTag")
    public final void deleteCategorieFromTag(@RequestParam final long idTag) {
        Tag tag = tagRepository.findTagsById(idTag);
        System.out.println("category id : " +tag.getCategory().getId());
        tagService.deleteCategory(tag);
        System.out.println("category name : " +tag.getCategory().getname());
        System.out.println("category id : " +tag.getCategory().getId());
    }
}
