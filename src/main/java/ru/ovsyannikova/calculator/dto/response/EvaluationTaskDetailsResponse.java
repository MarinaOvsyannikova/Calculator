package ru.ovsyannikova.calculator.dto.response;

public class EvaluationTaskDetailsResponse {
    private Long id;
    private String date;
    private String task;
    private Double result;

    public EvaluationTaskDetailsResponse(Long id, String date, String task, Double result) {
        this.id = id;
        this.date = date;
        this.task = task;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
