package fr.gamedev.question.question.data;

import javax.persistence.Entity;

@Entity
public class PendingResponse {

    private  int IdUser;
    private  int IdQuestion;

    private  Enum<Status> Status;

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int idUser) {
        IdUser = idUser;
    }

    public int getIdQuestion() {
        return IdQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        IdQuestion = idQuestion;
    }

    public Enum<fr.gamedev.question.question.data.Status> getStatus() {
        return Status;
    }

    public void setStatus(Enum<fr.gamedev.question.question.data.Status> status) {
        Status = status;
    }
}
