package ru.ovsyannikova.calculator.domain.entities;


import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class EvaluationTask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String task;
    private Date created;
    private Double result;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");

    public EvaluationTask(String task, Double result, String date) throws ParseException {
        this.task = task;
        this.result = result;
        this.created = format.parse(date);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "EvaluationTask{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", created=" + created +
                ", result=" + result +
                ", format=" + format +
                '}';
    }
}
