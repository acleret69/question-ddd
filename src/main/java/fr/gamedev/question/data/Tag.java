package fr.gamedev.question.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author djer1
 *
 */
@Entity
public class Tag {

    /**
     * id auto generated.
     */
    @GeneratedValue
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

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param newCategory the category to set
     */
    public void setCategory(final Category newCategory) {
        this.category = newCategory;
    }

}
