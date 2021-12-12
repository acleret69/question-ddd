package fr.gamedev.question.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author djer1
 *
 */
@Entity
public class Question {
    /**
     * id auto generated.
     */
    @GeneratedValue
    @Id
    private long id;
    /**
     * content of the question.
     */
    private String content;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param newid the id to set
     */
    public void setId(final long newid) {
        this.id = newid;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param newcontent the content to set
     */
    public void setContent(final String newcontent) {
        this.content = newcontent;
    }

}
