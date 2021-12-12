package fr.gamedev.question.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author djer1
 *
 */
@Entity
public class Category {

    /**
     * id auto generated.
     */
    @GeneratedValue
    @Id
    private long id;
    /**
     * category name.
     */
    private String nom;

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
    public String getnom() {
        return nom;
    }

    /**
     * @param newNom the value to set
     */
    public void setValue(final String newNom) {
        this.nom = newNom;
    }

}
