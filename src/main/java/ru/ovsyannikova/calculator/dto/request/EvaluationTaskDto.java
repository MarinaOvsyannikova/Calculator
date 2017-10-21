package ru.ovsyannikova.calculator.dto.request;

public class EvaluationTaskDto {
    private String task;

    public EvaluationTaskDto(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
