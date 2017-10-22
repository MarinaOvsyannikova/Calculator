package ru.ovsyannikova.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ovsyannikova.calculator.domain.entity.EvaluationTask;
import ru.ovsyannikova.calculator.domain.entity.NumberCounter;
import ru.ovsyannikova.calculator.domain.repository.EvaluationTaskRepository;

import java.io.IOException;

@Service
public class EvaluationTaskService {
    private Evaluator evaluator;
    private EvaluationTaskRepository taskRepository;

    @Autowired
    public EvaluationTaskService(Evaluator evaluator, EvaluationTaskRepository taskRepository) {
        this.evaluator = evaluator;
        this.taskRepository = taskRepository;
    }

    public EvaluationResult evaluate(String task) throws IOException {
        try{
            return evaluator.getResult(task);
        } catch (IOException ex) {
            throw new IllegalArgumentException("Wrong expression for evaluation: " + task);
        }
    }

    public Iterable<EvaluationTask> getAllTasks() {
        return taskRepository.findAll();
    }

    public Number countTasksbyDate(String date) {
        return taskRepository.countAllByCreated(date);
    }

    public Iterable<EvaluationTask> findAllByDate(String date) {
        return taskRepository.findAllByCreated(date);
    }


}
