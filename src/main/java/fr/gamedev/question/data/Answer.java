package fr.gamedev.question.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author djer1
 *
 */
@Entity
public class Answer {
    /**
     * id auto generated.
     */
    @GeneratedValue
    @Id
    private long id;
    /**
     * Question to Answer.
     */
    @OneToOne
    private Question question;
    /**
     * Correct Answer.
     */
    private Boolean correctAnswer;

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
     * @return the question
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * @param newQuestion the question to set
     */
    public void setQuestion(final Question newQuestion) {
        this.question = newQuestion;
    }

    /**
     * @return the correctAnswer
     */
    public Boolean getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * @param answer the correctAnswer to set
     */
    public void setCorrectAnswer(final Boolean answer) {
        this.correctAnswer = answer;
    }

}
