package fr.gamedev.question.question.data;

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

    private int idUser;
    /**
     * Correct Answer.
     */

    private int idQuestion;
    /**
     * Points of the user on this answer.
     */

    private Integer points;

    /**
     * true or false if response is good
     */
     private boolean correctAnswer;

    /**
     * response of user
     */
    private String Response;


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
    public int getIdUser() {
        return idUser;
    }

    /**
     * @param idUser of the user to set
     */
    public void setIdUser(int idUser) {
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
        return Response;
    }

    /**
     * @param response the answer to set
     */
    public void setResponse(String response) {
        Response = response;
    }

    /**
     * @return the idQuestion
     */
    public int getIdQuestion() {
        return idQuestion;
    }

    /**
     * @param idQuestion the id question to set
     */
    public void setIdQuestion(int idQuestion) {
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
    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

}
