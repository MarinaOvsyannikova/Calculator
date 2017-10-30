package ru.ovsyannikova.calculator.dto.request;

import io.swagger.annotations.ApiModelProperty;

public class OperationDto {
    @ApiModelProperty(value = "Operation", required = true, dataType = "java.lang.String")
    private String operation;

    public OperationDto() {
    }

    public OperationDto(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
