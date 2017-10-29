package ru.ovsyannikova.calculator.service;

import java.util.HashMap;

public class EvaluationResult {
    private String task;
    private Double result;
    private HashMap<Double, Integer> numberAmounts;
    private HashMap<String, Integer> operationAmounts;

    public EvaluationResult() {
    }

    public EvaluationResult(String task, Double result, HashMap<Double, Integer> numberAmounts, HashMap<String, Integer> operationAmounts) {
        this.task = task;
        this.result = result;
        this.numberAmounts = numberAmounts;
        this.operationAmounts = operationAmounts;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public HashMap<Double, Integer> getNumberAmounts() {
        return numberAmounts;
    }

    public void setNumberAmounts(HashMap<Double, Integer> numberAmounts) {
        this.numberAmounts = numberAmounts;
    }

    public HashMap<String, Integer> getOperationAmounts() {
        return operationAmounts;
    }

    public void setOperationAmounts(HashMap<String, Integer> operationAmounts) {
        this.operationAmounts = operationAmounts;
    }
}
