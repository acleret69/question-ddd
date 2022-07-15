package fr.gamedev.user.service;

import fr.gamedev.user.data.User;
import fr.gamedev.user.repository.UserRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService   {

    public void updateUser(User user, String login, String lastName)
    {
        user.setLastName(lastName);
        user.setLogin(login);
    }

  /*  public final User createUser ( final long id ) {
        getUser
    }

    public findUser*/
}
