package fr.gamedev.user.controller;

import fr.gamedev.user.data.User;
import fr.gamedev.user.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/createUser")
    public final User createUser (@RequestParam final long id, @RequestParam final String login,
                                  @RequestParam final String lastName) {
        return new User(id,login,lastName);
    }

    @GetMapping("/createUser")
    public final User createUser (@RequestParam final long id ) {

        User test = new User(1, "","");
        

        return findUser();
    }
  /*  @GetMapping("/createUser")
    public final User createUser (@RequestParam final long id ) {
        return findUser();
    }*/
}
