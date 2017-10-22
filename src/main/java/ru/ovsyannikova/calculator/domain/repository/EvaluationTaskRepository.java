package ru.ovsyannikova.calculator.domain.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ovsyannikova.calculator.domain.entity.EvaluationTask;

import java.util.List;

public interface EvaluationTaskRepository extends CrudRepository<EvaluationTask, Long>{
    List<EvaluationTask> findAllByCreated(String date);

    Number countAllByCreated(String date);


}
