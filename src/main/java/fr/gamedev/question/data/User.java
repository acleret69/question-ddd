package fr.gamedev.question.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author djer1
 *
 */
@Entity
public class User {

    /**
     * id auto generated.
     */
    @GeneratedValue
    @Id
    private long id;
    /**
     * user login.
     */
    private String login;
    /**
     * user last Name.
     */
    private String lastName;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param identifiant the id to set
     */
    public void setId(final long identifiant) {
        this.id = identifiant;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param newlogin the login to set
     */
    public void setLogin(final String newlogin) {
        this.login = newlogin;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param newlastName the lastName to set
     */
    public void setLastName(final String newlastName) {
        this.lastName = newlastName;
    }

}
