package com.microservice.user.controller;

import com.google.gson.JsonObject;
import com.microservice.user.data.User;
import com.microservice.user.repository.UserRepository;
import com.microservice.user.service.UserService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

/**
 * UserController class.
 */
@RestController
public class UserController {
    /**
     * The userService.
     */
    private final transient UserService userService;
    /**
     * The userRepository.
     */
    private final transient UserRepository userRepository;

    /**
     * UserController constructor.
     * @param userRepository a user repository
     * @param userService a user service
     */
    public UserController(
            final UserRepository userRepository,
            final UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    /**
     * deleteUserById method.
     * @param idUser a user ID
     */
    @DeleteMapping("/deleteUserById")
    public final void deleteUserById(
            @RequestParam final long idUser) {
        userRepository.deleteById(idUser);
    }

    /**
     * updateUser method.
     * @param idUser a user ID
     * @param login a login
     * @param lastName a lastname
     */
    @PostMapping("/updateUser")
    public final void updateUser(
            @RequestParam final long idUser,
            @RequestParam final String login,
            @RequestParam final String lastName) {
        final User user = userRepository.findUserById(idUser);
        userService.updateUser(user, login, lastName);
        userRepository.save(user);
    }

    /**
     * findQuestionByTagName method.
     * @param tagName a tag name
     * @return a JsonObject
     */
    @GetMapping("/findQuestionByTagName")
    public final JsonObject findQuestionByTagName(@RequestParam final String tagName) {
        return userService.findQuestionByTagName(tagName);
    }
}
