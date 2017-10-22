package ru.ovsyannikova.calculator.service;

import java.util.HashMap;

public class EvaluationResult {
    private String task;
    private Double result;
    private HashMap<Number, Integer> numberAmounts;

    public EvaluationResult() {
    }

    public EvaluationResult(String task, Double result, HashMap<Number, Integer> numberAmounts) {
        this.task = task;
        this.result = result;
        this.numberAmounts = numberAmounts;
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

    public HashMap<Number, Integer> getNumberAmounts() {
        return numberAmounts;
    }

    public void setNumberAmounts(HashMap<Number, Integer> numberAmounts) {
        this.numberAmounts = numberAmounts;
    }
}
