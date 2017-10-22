package ru.ovsyannikova.calculator.domain.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.ovsyannikova.calculator.domain.entity.NumberCounter;


public interface NumberCounterRepository extends CrudRepository<NumberCounter, Long>{
    NumberCounter findByNumber(Number number);

//    @Query("select max(n.amount) from Numbers n where n.number = :number")
//    Number findMaxOperationCounter(@Param("number") String operation);

//    @Query("select max(n.amount) from Numbers n")
//    Number findMaxNumberAmount();

//    @Query("select max(n.amount) from NumberCounter n")
//    Number findMaxAmount();

    @Query("select nc from NumberCounter nc where nc.amount = (select max(nc1.amount) from NumberCounter nc1)")
    NumberCounter findMostPopular();


}
