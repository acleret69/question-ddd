package category.data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author djer1
 *
 */
@Entity
@Table(name = "category")
public class Category {

    /**
     * id auto generated.
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    /**
     * category name.
     */
    private String name;
    /**
     * id tag.
     */
    private transient long idTag;

    /**
     * Category constructor.
     */
    public Category() { }

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
     * @return the value
     */
    public String getname() {
        return name;
    }

    /**
     * @param newName the value to set
     */
    public void setValue(final String newName) {
        this.name = newName;
    }

    /**
     * @return the Tag Id
     */
    public long getIdTag() {
        return idTag;
    }

    /**
     * @param idTag  the Id Tag
     */
    public void setIdTag(final long idTag) {
        this.idTag = idTag;
    }
}
