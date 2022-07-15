package fr.gamedev.user.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fr.gamedev.user.data.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService   {

    public static void updateUser(User user, String login, String lastName) {
        user.setLastName(lastName);
        user.setLogin(login);
    }

    public static JsonObject findQuestionByTagName(String tagName) {
        final String uri = "http://localhost:8081/findQuestionByTagName?tagName=";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri + tagName, String.class);
        result = result.replace("[", "").replace("]", "");
        JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();

        return jsonObject;
    }


  /*  public final User createUser ( final long id ) {
        getUser
    }

    public findUser*/
}
