package ru.ovsyannikova.calculator.domain.number.model;

import io.swagger.models.auth.In;

public class NumberCounter {
    private Long id;
    private Double number;
    private Integer amount;

    public NumberCounter(Double number, Integer amount) {
        this.number = number;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
