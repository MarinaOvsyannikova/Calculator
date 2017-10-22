package ru.ovsyannikova.calculator.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ovsyannikova.calculator.dto.request.DateDto;
import ru.ovsyannikova.calculator.dto.request.OperationDto;
import ru.ovsyannikova.calculator.dto.response.EvaluationTasksResponse;
import ru.ovsyannikova.calculator.dto.response.NumberCounterDetailsResponse;
import ru.ovsyannikova.calculator.dto.response.TasksCountResponse;
import ru.ovsyannikova.calculator.service.EvaluationTaskService;
import ru.ovsyannikova.calculator.service.NumberCounterService;

@Controller
public class StatisticsController {
    private EvaluationTaskService taskService;
    private NumberCounterService counterService;

    @Autowired
    public StatisticsController(EvaluationTaskService taskService, NumberCounterService counterService) {
        this.taskService = taskService;
        this.counterService = counterService;
    }

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
