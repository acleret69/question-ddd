/**
 *
 */
package fr.gamedev.question.greeting;

/**
 * @author djer1
 *
 */
public class Greeting {
    /**
     * Id.
     */
    private final long id;
    /**
     * Content of the greeting.
     */
    private final String content;

    public Greeting(final long newid, final String newcontent) {
        this.id = newid;
        this.content = newcontent;
    }
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

}
