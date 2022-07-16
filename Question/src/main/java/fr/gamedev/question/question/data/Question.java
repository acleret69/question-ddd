package fr.gamedev.question.question.data;

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
     * @param newcontent the content to set
     */
    public void setContent(final String newcontent) {
        this.content = newcontent;
    }


    /**
     * @return the id tag
     */
    public long getIdTag() {
        return idTag;
    }

    /**
     * @param newidTag the id to set
     */
    public void setIdTag(final int newidTag) {
        this.idTag = newidTag;
    }

}
