package ru.ovsyannikova.calculator.dto.response;

import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition
public class EvaluationTaskDetailsResponse {
    private Double result;

    public EvaluationTaskDetailsResponse(Double result) {
        this.result = result;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
