package ru.ovsyannikova.calculator.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.ovsyannikova.calculator.domain.entity.EvaluationTask;
import ru.ovsyannikova.calculator.domain.entity.NumberCounter;
import ru.ovsyannikova.calculator.domain.repository.NumberCounterRepository;
import ru.ovsyannikova.calculator.dto.request.DateDto;
import ru.ovsyannikova.calculator.dto.request.EvaluationTaskDto;
import ru.ovsyannikova.calculator.dto.response.EvaluationTaskDetailsResponse;
import ru.ovsyannikova.calculator.dto.response.EvaluationTasksResponse;
import ru.ovsyannikova.calculator.dto.response.NumberCounterResponse;
import ru.ovsyannikova.calculator.dto.response.TasksCountResponse;
import ru.ovsyannikova.calculator.service.EvaluationResult;
import ru.ovsyannikova.calculator.service.EvaluationResultService;
import ru.ovsyannikova.calculator.service.EvaluationTaskService;

import java.io.IOException;

@RestController
public class EvaluationTaskController {
    private EvaluationTaskService taskService;
    private EvaluationResultService resultService;
    private NumberCounterRepository numberCounterRepository;

    @Autowired
    public EvaluationTaskController(EvaluationTaskService taskService, EvaluationResultService resultService, NumberCounterRepository numberCounterRepository) {
        this.taskService = taskService;
        this.resultService = resultService;
        this.numberCounterRepository = numberCounterRepository;
    }

//    @RequestMapping(value = "/calculations", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
//    public EvaluationTasksResponse getAllTasks() {
//        Iterable<EvaluationTask> evaluationTaskList = taskService.getAllTasks();
//        EvaluationTasksResponse response = new EvaluationTasksResponse(evaluationTaskList);
//        return response;
//    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public EvaluationTaskDetailsResponse createNewRecord(EvaluationTaskDto request) throws IOException {
        EvaluationResult evaluationResult = taskService.evaluate(request.getTask());
        resultService.collectData(evaluationResult);
        EvaluationTaskDetailsResponse response = new EvaluationTaskDetailsResponse(evaluationResult.getResult());
        return response;
    }

//    @RequestMapping(value = "/numbers", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
//    public NumberCounterResponse showNumbers() {
//        Iterable<NumberCounter> numberCounterList = numberCounterRepository.findAll();
//        NumberCounterResponse response = new NumberCounterResponse(numberCounterList);
//        return response;
//    }

    @RequestMapping(value = "/count", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public TasksCountResponse countTaskByDate(DateDto request) {
        TasksCountResponse response = new TasksCountResponse(taskService.countTasksbyDate(request.getDate()));
        return response;
    }

    @RequestMapping(value = "/ondate", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public EvaluationTasksResponse findTasksByDate(DateDto request) {
        EvaluationTasksResponse response = new EvaluationTasksResponse(taskService.findAllByDate(request.getDate()));
        return response;
    }
}
