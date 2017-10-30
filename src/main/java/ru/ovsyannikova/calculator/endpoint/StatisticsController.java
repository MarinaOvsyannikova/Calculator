package ru.ovsyannikova.calculator.endpoint;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.ovsyannikova.calculator.dto.request.DateDto;
import ru.ovsyannikova.calculator.dto.request.OperationDto;
import ru.ovsyannikova.calculator.dto.response.EvaluationTasksResponse;
import ru.ovsyannikova.calculator.dto.response.NumberCounterResponse;
import ru.ovsyannikova.calculator.dto.response.TasksCountResponse;
import ru.ovsyannikova.calculator.service.EvaluationTaskService;
import ru.ovsyannikova.calculator.service.NumberCounterService;

import java.sql.SQLException;
import java.text.ParseException;

@Controller
public class StatisticsController {
    private EvaluationTaskService taskService;
    private NumberCounterService counterService;

    @Autowired
    public StatisticsController(EvaluationTaskService taskService, NumberCounterService counterService) {
        this.taskService = taskService;
        this.counterService = counterService;
    }

    @ApiOperation(value = "Count tasks by date with format: dd-MM-yyyy", response = TasksCountResponse.class)
    @RequestMapping(value = "/count", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody TasksCountResponse countTaskByDate(DateDto request) throws SQLException, ParseException {
        TasksCountResponse response = new TasksCountResponse(taskService.countTasksByDate(request.getDate()));
        return response;
    }

    @ApiOperation(value = "Get list of tasks by date with format: dd-MM-yyyy", response = EvaluationTasksResponse.class)
    @RequestMapping(value = "/ondate", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody EvaluationTasksResponse findTasksByDate(DateDto request) throws SQLException, ParseException {
        EvaluationTasksResponse response = new EvaluationTasksResponse(taskService.findAllByDate(request.getDate()));
        return response;
    }

    @ApiOperation(value = "Find the most popular number", response = NumberCounterResponse.class)
    @RequestMapping(value = "/popular", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody NumberCounterResponse findMostPopularNumber() throws SQLException {
        NumberCounterResponse response = new NumberCounterResponse(counterService.getPopularNumber());
        return response;
    }

    @ApiOperation(value = "Count tasks with given operation: (, ), +, -, *, /, ^", response = TasksCountResponse.class)
    @RequestMapping(value = "/operation", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody TasksCountResponse countTasksWithOperation(OperationDto request) throws SQLException {
        TasksCountResponse response = new TasksCountResponse(taskService.countTasksByOperation(request.getOperation()));
        return response;
    }

    @ApiOperation(value = "Get list of tasks with given operation: (, ), +, -, *, /, ^", response = EvaluationTasksResponse.class)
    @RequestMapping(value = "/onoperation", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody EvaluationTasksResponse findTasksWithOperation(OperationDto request) throws SQLException {
        EvaluationTasksResponse response = new EvaluationTasksResponse(taskService.findTasksByOperation(request.getOperation()));
        return response;
    }
}
