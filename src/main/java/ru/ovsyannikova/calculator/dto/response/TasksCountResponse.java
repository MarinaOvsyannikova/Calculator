package ru.ovsyannikova.calculator.dto.response;

import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition
public class TasksCountResponse {

    private Number count;

    public TasksCountResponse(Number count) {
        this.count = count;
    }

    public Number getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
