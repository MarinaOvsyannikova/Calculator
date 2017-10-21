package ru.ovsyannikova.calculator.dto.response;

import ru.ovsyannikova.calculator.domain.entity.EvaluationTask;

public class EvaluationTasksResponce {
    private Iterable<EvaluationTask> evaluationTasks;

    public EvaluationTasksResponce(Iterable<EvaluationTask> evaluationTasks) {
        this.evaluationTasks = evaluationTasks;
    }

    public Iterable<EvaluationTask> getEvaluationTasks() {
        return evaluationTasks;
    }

    public void setEvaluationTasks(Iterable<EvaluationTask> evaluationTasks) {
        this.evaluationTasks = evaluationTasks;
    }
}
