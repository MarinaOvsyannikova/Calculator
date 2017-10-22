package ru.ovsyannikova.calculator.dto.request;

public class DateDto {
    String date;

    public DateDto() {
    }

    public DateDto(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
