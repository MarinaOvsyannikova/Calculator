package ru.ovsyannikova.calculator.domain.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ovsyannikova.calculator.domain.entity.EvaluationTask;

public interface EvaliationTaskRepository extends CrudRepository<EvaluationTask, Long>{
}
