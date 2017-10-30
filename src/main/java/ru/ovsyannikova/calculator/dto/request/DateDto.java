package ru.ovsyannikova.calculator.dto.request;

import io.swagger.annotations.ApiModelProperty;

public class DateDto {
    @ApiModelProperty(value = "Date", required = true, dataType = "java.lang.String")
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
