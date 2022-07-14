package category.controller;

import category.data.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class TagController {

    @GetMapping("/tagController")
    public final Tag getTag(@RequestParam final long categoryID, @RequestParam final String name) {
        Tag Tag = new Tag();
        Tag.setId(categoryID);
        Tag.setName(name);

        return Tag;
    }
}
