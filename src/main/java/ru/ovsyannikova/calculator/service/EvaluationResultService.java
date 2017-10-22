package ru.ovsyannikova.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ovsyannikova.calculator.domain.entity.EvaluationTask;
import ru.ovsyannikova.calculator.domain.entity.NumberCounter;
import ru.ovsyannikova.calculator.domain.repository.EvaluationTaskRepository;
import ru.ovsyannikova.calculator.domain.repository.NumberCounterRepository;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class EvaluationResultService {
    private EvaluationTaskRepository evaluationTaskRepository;
    private NumberCounterRepository numberCounterRepository;

    @Autowired
    public EvaluationResultService(EvaluationTaskRepository evaluationTaskRepository, NumberCounterRepository numberCounterRepository) {
        this.evaluationTaskRepository = evaluationTaskRepository;
        this.numberCounterRepository = numberCounterRepository;
    }

    @Transactional
    public void collectData(EvaluationResult evaluationResult) {
        saveTask(evaluationResult);
        collectNumbersAmounts(evaluationResult);
    }

    public void saveTask(EvaluationResult evaluationResult) {
        OffsetDateTime time = OffsetDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String resultDate = time.format(formatter);

        EvaluationTask evaluationTask = new EvaluationTask(evaluationResult.getTask(), resultDate, evaluationResult.getResult());
        evaluationTaskRepository.save(evaluationTask);
    }

    public void collectNumber(Number number, Integer count) {
        NumberCounter numberCounter = numberCounterRepository.findByNumber(number);
        if (numberCounter == null)
            numberCounter = new NumberCounter(number, (long) 0);
        numberCounter.setAmount(numberCounter.getAmount() + count);
        numberCounterRepository.save(numberCounter);
    }

    private void collectNumbersAmounts(EvaluationResult evaluationResult) {
        HashMap<Number, Integer> numberAmounts = evaluationResult.getNumberAmounts();
        Set<Map.Entry<Number, Integer>> entries = numberAmounts.entrySet();
        for (Map.Entry<Number, Integer> elem: entries) {
            collectNumber(elem.getKey(), elem.getValue());
        }
    }

}
