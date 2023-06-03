package poller.questionContext.domain.model;

import javax.persistence.*;

/**
 * @author djer1
 */
@Entity
@Table(name = "userAnswer")
public class UserAnswer {

    /**
     * id auto generated.
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    /**
     * User answering.
     */

    private long idUser;
    /**
     * Correct Answer.
     */

    private long idQuestion;
    /**
     * Points of the user on this answer.
     */

    private Integer points;

    /**
     * true or false if response is good.
     */
     private boolean correctAnswer;

    /**
     * response of user.
     */
    private String response;

    /**
     * UserAnswer constructor.
     */
    public UserAnswer() { }

    /**
     * getId method.
     * @return a userAnswer ID
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
     * @return the user id
     */
    public long getIdUser() {
        return idUser;
    }

    /**
     * @param idUser of the user to set
     */
    public void setIdUser(final long idUser) {
        this.idUser = idUser;
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
    public String getResponse() {
        return response;
    }

    /**
     * @param response the answer to set
     */
    public void setResponse(final String response) {
        this.response = response;
    }

    /**
     * @return the idQuestion
     */
    public long getIdQuestion() {
        return idQuestion;
    }

    /**
     * @param idQuestion the id question to set
     */
    public void setIdQuestion(final long idQuestion) {
        this.idQuestion = idQuestion;
    }

    /**
     * @return the response true if correct and false if wrong
     */
    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * @param correctAnswer Correct answer to set
     */
    public void setCorrectAnswer(final boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

}
