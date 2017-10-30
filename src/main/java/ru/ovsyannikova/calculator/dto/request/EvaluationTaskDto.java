package ru.ovsyannikova.calculator.dto.request;

import io.swagger.annotations.ApiModelProperty;

public class EvaluationTaskDto {
    @ApiModelProperty(value = "Task", required = true, dataType = "java.lang.String")
    private String task;

    public EvaluationTaskDto() {
    }

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
