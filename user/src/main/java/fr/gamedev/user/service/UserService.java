package fr.gamedev.user.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fr.gamedev.user.data.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * UserService class.
 */
@Service
public class UserService   {
    /**
     * updateUser class.
     * @param user
     * @param login
     * @param lastName
     */
    public static void updateUser(
            final User user,
            final String login,
            final String lastName) {
        user.setLastName(lastName);
        user.setLogin(login);
    }

    /**
     * findQuestionByTagName method.
     * @param tagName a tag name
     * @return a JsonObject
     */
    public static JsonObject findQuestionByTagName(final String tagName) {
        final String uri = "http://localhost:8081/findQuestionByTagName?tagName=";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri + tagName, String.class);
        result = result.replace("[", "").replace("]", "");
        JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();

        return jsonObject;
    }
}
