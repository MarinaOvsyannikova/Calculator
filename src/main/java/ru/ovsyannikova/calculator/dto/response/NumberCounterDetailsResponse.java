package ru.ovsyannikova.calculator.dto.response;

public class NumberCounterDetailsResponse {
    private Long id;
    private Double number;
    private Long amount;

    public NumberCounterDetailsResponse(Long id, Double number, Long amount) {
        this.id = id;
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
