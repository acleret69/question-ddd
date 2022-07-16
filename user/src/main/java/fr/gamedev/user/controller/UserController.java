package fr.gamedev.user.controller;

import com.google.gson.JsonObject;
import fr.gamedev.user.data.User;
import fr.gamedev.user.repository.UserRepository;
import fr.gamedev.user.service.UserService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class UserController {
    /**
     * The userService.
     */
    private final UserService userService;
    /**
     * The userRepository.
     */
    private final UserRepository userRepository;

    public UserController(
            final UserRepository userRepository,
            final UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @DeleteMapping("/deleteUserById")
    public final void deleteUserById(
            @RequestParam final long idUser) {
        userRepository.deleteById(idUser);
    }

    @PostMapping("/updateUser")
    public final void updateUser(
            @RequestParam final long idUser,
            @RequestParam final String login,
            @RequestParam final String lastName) {
        User user = userRepository.findUserById(idUser);
        userService.updateUser(user, login, lastName);
        userRepository.save(user);
    }

    @GetMapping("/findQuestionByTagName")
    public final JsonObject findQuestionByTagName(@RequestParam final String tagName) {
        return userService.findQuestionByTagName(tagName);
    }



    /* @GetMapping("/createUser")
    public final User createUser (@RequestParam final long id, @RequestParam final String login,
                                  @RequestParam final String lastName) {
        return new User(id,login,lastName);
    }

   @GetMapping("/createUser")
    public final User createUser (@RequestParam final long id ) {

        User test = new User(1, "","");

        return findUser();
    }*/
  /*  @GetMapping("/createUser")
    public final User createUser (@RequestParam final long id ) {
        return findUser();
    }*/
}
