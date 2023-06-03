package poller.skillContext.domain.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author djer1
 *
 */
@Entity
@Table(name = "tag")
public class Tag {

    /**
     * The auto generated ID.
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    /**
     * The tag name.
     */
    private String name;

    /**
     * Liaison avec category.
     */
    @ManyToOne
    private Category category;

    /**
     * Tag constructor.
     */
    public Tag() { }

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

    /**
     * getCategory method.
     * @return a category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * setCategory method.
     * @param category a category
     */
    public void setCategory(final Category category) {
        this.category = category;
    }

}
