package fr.gamedev.question.question.data;

import javax.persistence.*;

@Entity
@Table(name = "pendingResponse")
public class PendingResponse {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private  long Id;

    private  long IdUser;

    private  long IdQuestion;

    private  Enum<Status> Status;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getIdUser() {
        return IdUser;
    }

    public void setIdUser(long idUser) {
        IdUser = idUser;
    }

    public long getIdQuestion() {
        return IdQuestion;
    }

    public void setIdQuestion(long idQuestion) {
        IdQuestion = idQuestion;
    }

    public Enum<fr.gamedev.question.question.data.Status> getStatus() {
        return Status;
    }

    public void setStatus(Enum<fr.gamedev.question.question.data.Status> status) {
        Status = status;
    }
}
