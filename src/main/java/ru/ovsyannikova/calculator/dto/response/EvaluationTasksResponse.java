package ru.ovsyannikova.calculator.dto.response;

import ru.ovsyannikova.calculator.domain.entity.EvaluationTask;

public class EvaluationTasksResponse {
    private Iterable<EvaluationTask> evaluationTasks;

    public EvaluationTasksResponse(Iterable<EvaluationTask> evaluationTasks) {
        this.evaluationTasks = evaluationTasks;
    }

    public Iterable<EvaluationTask> getEvaluationTasks() {
        return evaluationTasks;
    }

    public void setEvaluationTasks(Iterable<EvaluationTask> evaluationTasks) {
        this.evaluationTasks = evaluationTasks;
    }
}
