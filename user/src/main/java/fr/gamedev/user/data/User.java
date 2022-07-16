package fr.gamedev.user.data;

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
@Table(name = "users")
public class User {

    /**
     * id auto generated.
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
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
     * User constructor.
     */
    public User() {
    }

    /**
     * User constructor.
     * @param id an ID
     * @param login a login
     * @param lastName a lastname
     */
    public User(
            final long id,
            final String login,
            final String lastName) {
        this.id = id;
        this.login = login;
        this.lastName = lastName;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(final String login) {
        this.login = login;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

}
