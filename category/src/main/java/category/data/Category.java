package category.data;

import javax.persistence.*;

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
    private long idTag;

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


    public long getIdTag() {
        return idTag;
    }

    public void setIdTag(long idTag) {
        this.idTag = idTag;
    }
}
