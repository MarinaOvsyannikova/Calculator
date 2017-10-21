package ru.ovsyannikova.calculator.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.ovsyannikova.calculator.domain.entity.EvaluationTask;
import ru.ovsyannikova.calculator.dto.request.EvaluationTaskDto;
import ru.ovsyannikova.calculator.dto.response.EvaluationTaskDetailsResponse;
import ru.ovsyannikova.calculator.dto.response.EvaluationTasksResponse;
import ru.ovsyannikova.calculator.service.EvaluationTaskService;

import java.util.List;

@RestController
public class EvaluationTaskController {
    private EvaluationTaskService taskService;

    @Autowired
    public EvaluationTaskController(EvaluationTaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/calculations", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public EvaluationTasksResponse getAllTasks() {
        List<EvaluationTask> evaluationTaskList = taskService.getAllTasks();
        EvaluationTasksResponse response = new EvaluationTasksResponse(evaluationTaskList);
        return response;
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public EvaluationTaskDetailsResponse createNewRecord(EvaluationTaskDto request) {
        EvaluationTask task = taskService.createEvaluationTask(request);
        EvaluationTaskDetailsResponse response = new EvaluationTaskDetailsResponse(task.getId(), task.getCreated(), task.getTask(), task.getResult());
        return response;
    }
}
