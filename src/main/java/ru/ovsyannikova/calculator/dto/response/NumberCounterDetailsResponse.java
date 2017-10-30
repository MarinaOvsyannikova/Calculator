package ru.ovsyannikova.calculator.dto.response;

import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition
public class NumberCounterDetailsResponse {
    private Number number;

    public NumberCounterDetailsResponse(Number number) {
        this.number = number;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }
}
