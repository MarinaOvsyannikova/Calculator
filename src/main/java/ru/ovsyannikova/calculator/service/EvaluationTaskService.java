package ru.ovsyannikova.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ovsyannikova.calculator.domain.entity.EvaluationTask;
import ru.ovsyannikova.calculator.domain.repository.EvaliationTaskRepository;
import ru.ovsyannikova.calculator.dto.request.EvaluationTaskDto;
import ru.ovsyannikova.calculator.evaluator.EvaluatorService;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EvaluationTaskService {
    private EvaliationTaskRepository evaliationTaskRepository;

    @Autowired
    public EvaluationTaskService(EvaliationTaskRepository evaliationTaskRepository) {
        this.evaliationTaskRepository = evaliationTaskRepository;
    }

    public List<EvaluationTask> getAllTasks() {
        return (List<EvaluationTask>) evaliationTaskRepository.findAll();
    }

    public EvaluationTask createEvaluationTask(EvaluationTaskDto evaluationTaskDto) {
        OffsetDateTime time = OffsetDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String resultDate = time.format(formatter);
        String task = evaluationTaskDto.getTask();

        EvaluationTask evaluationTask = new EvaluationTask(task, resultDate, EvaluatorService.evaluate(task));
        return evaliationTaskRepository.save(evaluationTask);
    }
}
