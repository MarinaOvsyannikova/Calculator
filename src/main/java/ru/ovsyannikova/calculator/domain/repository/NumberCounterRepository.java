package ru.ovsyannikova.calculator.domain.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.ovsyannikova.calculator.domain.entity.NumberCounter;

import java.util.List;

public interface NumberCounterRepository extends CrudRepository<NumberCounter, Long>{
    NumberCounter findByNumber(Number number);

}
