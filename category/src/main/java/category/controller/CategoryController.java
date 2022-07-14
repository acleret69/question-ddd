package category.controller;

import category.data.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author djer1
 *
 */
@RestController
public class CategoryController {

    @GetMapping("/categoryController")
    public final Category getCategory(@RequestParam final long categoryID, @RequestParam final String nom) {
        Category categorie = new Category();
        categorie.setId(categoryID);
        categorie.setValue(nom);
        /*
        String response;

        if (answer == Boolean.TRUE) {
// Ajouter des points

            response = "Bravo ! vous avez trouvé ! ";
        } else {
// Ne pas ajouter de points

            response = "Oops ! Ca n'est pas correcte";
        }
         */
        return categorie;
    }

}
