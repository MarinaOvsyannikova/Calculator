package ru.ovsyannikova.calculator.dto.response;

import io.swagger.annotations.SwaggerDefinition;
import ru.ovsyannikova.calculator.domain.task.model.Task;

@SwaggerDefinition
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
