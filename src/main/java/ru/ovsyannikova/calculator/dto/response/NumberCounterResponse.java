package ru.ovsyannikova.calculator.dto.response;


import ru.ovsyannikova.calculator.domain.number.model.NumberCounter;

public class NumberCounterResponse {
    Iterable<NumberCounter> numberCounters;

    public NumberCounterResponse(Iterable<NumberCounter> numberCounters) {
        this.numberCounters = numberCounters;
    }

    public Iterable<NumberCounter> getNumberCounters() {
        return numberCounters;
    }

    public void setNumberCounters(Iterable<NumberCounter> numberCounters) {
        this.numberCounters = numberCounters;
    }
}
