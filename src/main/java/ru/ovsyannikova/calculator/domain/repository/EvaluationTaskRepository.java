package ru.ovsyannikova.calculator.domain.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ovsyannikova.calculator.domain.entity.EvaluationTask;

import java.util.List;

public interface EvaluationTaskRepository extends CrudRepository<EvaluationTask, Long>{
    List<EvaluationTask> findAllByCreated(String date);

    Number countAllByCreated(String date);

    List<EvaluationTask> findByAdditionsAmountNot(Integer number);
    List<EvaluationTask> findBySubtractionsAmountNot(Integer number);
    List<EvaluationTask> findByPowersAmountNot(Integer number);
    List<EvaluationTask> findByDivisionsAmountNot(Integer number);
    List<EvaluationTask> findByMultiplicationsAmountNot(Integer number);
    List<EvaluationTask> findByLeftParenthesisAmountNot(Integer number);
    List<EvaluationTask> findByRightParenthesisAmountNot(Integer number);

    Long countByAdditionsAmountNot(Integer number);
    Long countBySubtractionsAmountNot(Integer number);
    Long countByPowersAmountNot(Integer number);
    Long countByDivisionsAmountNot(Integer number);
    Long countByMultiplicationsAmountNot(Integer number);
    Long countByLeftParenthesisAmountNot(Integer number);
    Long countByRightParenthesisAmountNot(Integer number);
}
