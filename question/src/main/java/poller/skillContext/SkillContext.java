package poller.skillContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import poller.skillContext.domain.model.Tag;

/**
 * CategoryApplication class.
 */
@SpringBootApplication
public class SkillContext implements RepositoryRestConfigurer {
   /**
    * SkillContext constructor.
    */
   public SkillContext() { }
   /**
    * Main method.
    * @param args arguments
    */
   public static void main(final String[] args) {
      SpringApplication.run(SkillContext.class, args);
   }

   /**
    * configureRepositoryRestConfiguration method.
    */
   @Override
   public void configureRepositoryRestConfiguration(
         final RepositoryRestConfiguration config,
         final CorsRegistry cors) {
      config.exposeIdsFor(Tag.class);
   }

}
