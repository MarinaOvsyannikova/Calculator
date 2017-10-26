package ru.ovsyannikova.calculator.testutils.requests;

public class EvaluationTestRequest {

    private String task;

    public EvaluationTestRequest() {
    }

    public EvaluationTestRequest(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
