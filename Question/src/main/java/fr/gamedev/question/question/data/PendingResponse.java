package fr.gamedev.question.question.data;

import javax.persistence.*;

@Entity
@Table(name = "pendingResponse")
public class PendingResponse {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private  long id;

    private  long idUser;

    private  long idQuestion;

    private  Enum<Status> status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Enum<fr.gamedev.question.question.data.Status> getStatus() {
        return status;
    }

    public void setStatus(Enum<fr.gamedev.question.question.data.Status> status) {
        this.status = status;
    }
}
