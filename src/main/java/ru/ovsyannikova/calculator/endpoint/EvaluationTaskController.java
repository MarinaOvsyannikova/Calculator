package ru.ovsyannikova.calculator.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.ovsyannikova.calculator.domain.entity.EvaluationTask;
import ru.ovsyannikova.calculator.dto.request.DateDto;
import ru.ovsyannikova.calculator.dto.request.EvaluationTaskDto;
import ru.ovsyannikova.calculator.dto.request.OperationDto;
import ru.ovsyannikova.calculator.dto.response.*;
import ru.ovsyannikova.calculator.service.EvaluationResult;
import ru.ovsyannikova.calculator.service.EvaluationResultService;
import ru.ovsyannikova.calculator.service.EvaluationTaskService;
import ru.ovsyannikova.calculator.service.NumberCounterService;

import java.io.IOException;

@RestController
public class EvaluationTaskController {
    private EvaluationTaskService taskService;
    private EvaluationResultService resultService;
    private NumberCounterService counterService;

    @Autowired
    public EvaluationTaskController(EvaluationTaskService taskService, EvaluationResultService resultService, NumberCounterService counterService) {
        this.taskService = taskService;
        this.resultService = resultService;
        this.counterService = counterService;
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
        TasksCountResponse response = new TasksCountResponse(taskService.countTasksByDate(request.getDate()));
        return response;
    }

    @RequestMapping(value = "/ondate", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public EvaluationTasksResponse findTasksByDate(DateDto request) {
        EvaluationTasksResponse response = new EvaluationTasksResponse(taskService.findAllByDate(request.getDate()));
        return response;
    }

    @RequestMapping(value = "/popular", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public NumberCounterDetailsResponse findMostPopularNumber() {
        NumberCounterDetailsResponse response = new NumberCounterDetailsResponse(counterService.getPopularNumber().getNumber());
        return response;
    }

    @RequestMapping(value = "/operation", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public TasksCountResponse countTasksWithOperation(OperationDto request) {
        TasksCountResponse response = new TasksCountResponse(taskService.countTasksByOperation(request.getOperation()));
        return response;
    }

    @RequestMapping(value = "/onoperation", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public EvaluationTasksResponse findTasksWithOperation(OperationDto request) {
        EvaluationTasksResponse response = new EvaluationTasksResponse(taskService.findTasksByOperation(request.getOperation()));
        return response;
    }
}
