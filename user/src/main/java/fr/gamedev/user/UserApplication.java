package fr.gamedev.user;

import fr.gamedev.user.data.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * UserApplication class.
 */
@SpringBootApplication
public class UserApplication implements RepositoryRestConfigurer {
   /**
    * UserApplication constructor.
    */
   public UserApplication() { }
   /**
    * main method.
    * @param args arguments
    */
   public static void main(final String[] args) {
      SpringApplication.run(UserApplication.class, args);
   }

   /**
    * configureRepositoryRestConfiguration method.
    * @param config a RepositoryRestConfiguration
    * @param cors a CorsRegistry
    */
   @Override
   public void configureRepositoryRestConfiguration(
         final RepositoryRestConfiguration config,
         final CorsRegistry cors) {
      config.exposeIdsFor(User.class);
   }
}
