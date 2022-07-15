package category.data;

import javax.persistence.*;

/**
 * @author djer1
 *
 */
@Entity
@Table(name = "tag")
public class Tag {

    /**
     * id auto generated.
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    
    /**
     * tag name.
     */
    private String name;

    /**
     * Liason avec category.
     */
    @ManyToOne
    private Category category;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param newId the id to set
     */
    public void setId(final long newId) {
        this.id = newId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param newName the value to set
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
