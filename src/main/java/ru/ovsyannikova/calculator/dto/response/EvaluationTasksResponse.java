package ru.ovsyannikova.calculator.dto.response;

import ru.ovsyannikova.calculator.domain.task.model.Task;

public class EvaluationTasksResponse {
    private Iterable<Task> evaluationTasks;

    public EvaluationTasksResponse(Iterable<Task> evaluationTasks) {
        this.evaluationTasks = evaluationTasks;
    }

    public Iterable<Task> getEvaluationTasks() {
        return evaluationTasks;
    }

    public void setEvaluationTasks(Iterable<Task> evaluationTasks) {
        this.evaluationTasks = evaluationTasks;
    }
}
