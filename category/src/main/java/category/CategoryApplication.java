package category;

import category.data.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * CategoryApplication class.
 */
@SpringBootApplication
public class CategoryApplication implements RepositoryRestConfigurer {
   /**
    * CategoryApplication constructor.
    */
   public CategoryApplication() { }
   /**
    * Main method.
    * @param args arguments
    */
   public static void main(final String[] args) {
      SpringApplication.run(CategoryApplication.class, args);
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
