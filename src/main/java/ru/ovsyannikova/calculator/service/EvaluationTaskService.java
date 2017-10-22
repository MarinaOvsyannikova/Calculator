package ru.ovsyannikova.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ovsyannikova.calculator.domain.entity.EvaluationTask;
import ru.ovsyannikova.calculator.domain.repository.EvaluationTaskRepository;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

@Service
public class EvaluationTaskService {
    private Evaluator evaluator;
    private EvaluationTaskRepository taskRepository;

    private HashMap<String, Function<Integer, List<EvaluationTask>>> findMethodsByOperation;
    private HashMap<String, Function<Integer, Long>> countMethodsByOperation;

    @Autowired
    public EvaluationTaskService(Evaluator evaluator, EvaluationTaskRepository taskRepository) {
        this.evaluator = evaluator;
        this.taskRepository = taskRepository;

        findMethodsByOperation = new HashMap<>();
        findMethodsByOperation.put("+", taskRepository::findByAdditionsAmountNot);
        findMethodsByOperation.put("-", taskRepository::findBySubtractionsAmountNot);
        findMethodsByOperation.put("*", taskRepository::findByMultiplicationsAmountNot);
        findMethodsByOperation.put("/", taskRepository::findByDivisionsAmountNot);
        findMethodsByOperation.put("^", taskRepository::findByPowersAmountNot);
        findMethodsByOperation.put("(", taskRepository::findByLeftParenthesisAmountNot);
        findMethodsByOperation.put(")", taskRepository::findByRightParenthesisAmountNot);

        countMethodsByOperation = new HashMap<>();
        countMethodsByOperation.put("+", taskRepository::countByAdditionsAmountNot);
        countMethodsByOperation.put("-", taskRepository::countBySubtractionsAmountNot);
        countMethodsByOperation.put("*", taskRepository::countByMultiplicationsAmountNot);
        countMethodsByOperation.put("/", taskRepository::countByDivisionsAmountNot);
        countMethodsByOperation.put("^", taskRepository::countByPowersAmountNot);
        countMethodsByOperation.put("(", taskRepository::countByLeftParenthesisAmountNot);
        countMethodsByOperation.put(")", taskRepository::countByRightParenthesisAmountNot);
    }

    public EvaluationResult evaluate(String task) throws IOException {
        try{
            return evaluator.getResult(task);
        } catch (IOException ex) {
            throw new IllegalArgumentException("Wrong expression for evaluation: " + task);
        }
    }

    public Number countTasksByDate(String date) {
        return taskRepository.countAllByCreated(date);
    }

    public Iterable<EvaluationTask> findAllByDate(String date) {
        return taskRepository.findAllByCreated(date);
    }



    public Number countTasksByOperation(String operation) {
        return countMethodsByOperation.get(operation).apply(0);
    }

    public Iterable<EvaluationTask> findTasksByOperation(String operation) {

        return findMethodsByOperation.get(operation).apply(0);
    }
}
