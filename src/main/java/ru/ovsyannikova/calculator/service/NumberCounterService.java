package ru.ovsyannikova.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ovsyannikova.calculator.domain.entity.NumberCounter;
import ru.ovsyannikova.calculator.domain.repository.NumberCounterRepository;

@Service
public class NumberCounterService {
    private NumberCounterRepository numberCounterRepository;

    @Autowired
    public NumberCounterService(NumberCounterRepository numberCounterRepository) {
        this.numberCounterRepository = numberCounterRepository;
    }

    public NumberCounter getPopularNumber() {
        return numberCounterRepository.findMostPopular();
    }

}
