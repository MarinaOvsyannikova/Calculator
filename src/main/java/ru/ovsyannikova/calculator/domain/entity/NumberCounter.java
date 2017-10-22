package ru.ovsyannikova.calculator.domain.entity;

import javax.persistence.*;

@Entity
public class NumberCounter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "number")
    private Number number;
    @Column(name = "amount")
    private Long amount;

    public NumberCounter() {
    }

    public NumberCounter(Number number, Long amount) {
        this.number = number;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
