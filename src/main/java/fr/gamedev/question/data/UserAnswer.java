package fr.gamedev.question.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 * @author djer1
 */
@Entity
public class UserAnswer {

    /**
     * id auto generated.
     */
    @GeneratedValue
    @Id
    private long id;
    /**
     * User answering.
     */
    @ManyToOne
    private User user;
    /**
     * Correct Answer.
     */
    @ManyToOne
    private Answer answer;
    /**
     * Points of the user on this answer.
     */
    private Integer points;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param theId the id to set
     */
    public void setId(final long theId) {
        this.id = theId;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param currentUser the user to set
     */
    public void setUser(final User currentUser) {
        this.user = currentUser;
    }

    /**
     * @return the points
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * @param userPoints the points to set
     */
    public void setPoints(final Integer userPoints) {
        this.points = userPoints;
    }

    /**
     * @return the answer
     */
    public Answer getAnswer() {
        return answer;
    }

    /**
     * @param userAnswer the answer to set
     */
    public void setAnswer(final Answer userAnswer) {
        this.answer = userAnswer;
    }

}
