package ru.ovsyannikova.calculator.domain.entity;

import javax.persistence.*;

@Entity
public class EvaluationTask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "task")
    private String task;
    @Column(name = "created")
    private String created;
    @Column(name = "result")
    private Double result;

    public EvaluationTask() {}

    public EvaluationTask(String task, String created, Double result) {
        this.task = task;
        this.created = created;
        this.result = result;
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

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
