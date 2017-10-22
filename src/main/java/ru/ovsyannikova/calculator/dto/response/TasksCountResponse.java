package ru.ovsyannikova.calculator.dto.response;

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
