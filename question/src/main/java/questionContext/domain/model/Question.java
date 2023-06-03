package questionContext.domain.model;

import javax.persistence.*;

/**
 * @author djer1
 *
 */
@Entity
@Table(name = "question")
public class Question {
    /**
     * id auto generated.
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    /**
     * content of the question.
     */
    private String content;
    /**
     * correct answer of the question.
     */
    private String correctAnswer;
    /**
     * id Tag of the question.
     */
    private int idTag;

    /**
     * Question constructor.
     */
    public Question() { }

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
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param newCorrectAnswer the content to set
     */
    public void setCorrectAnswer(final String newCorrectAnswer) {
        this.correctAnswer = newCorrectAnswer;
    }

    /**
     * @return the content
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * @param newContent the content to set
     */
    public void setContent(final String newContent) {
        this.content = newContent;
    }


    /**
     * @return the id tag
     */
    public long getIdTag() {
        return idTag;
    }

    /**
     * @param newIdTag the id to set
     */
    public void setIdTag(final int newIdTag) {
        this.idTag = newIdTag;
    }

}
