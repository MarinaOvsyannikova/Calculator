package ru.ovsyannikova.calculator.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.ovsyannikova.calculator.dto.request.EvaluationTaskDto;
import ru.ovsyannikova.calculator.dto.response.*;
import ru.ovsyannikova.calculator.service.EvaluationResult;
import ru.ovsyannikova.calculator.service.EvaluationResultService;
import ru.ovsyannikova.calculator.service.EvaluationTaskService;

import java.io.IOException;
import java.sql.SQLException;

@RestController
public class CalculationTaskController {
    private EvaluationTaskService taskService;
    private EvaluationResultService resultService;

    @Autowired
    public CalculationTaskController(EvaluationTaskService taskService, EvaluationResultService resultService) {
        this.taskService = taskService;
        this.resultService = resultService;
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public EvaluationTaskDetailsResponse createNewRecord(EvaluationTaskDto request) throws IOException, SQLException {
        EvaluationResult evaluationResult = taskService.evaluate(request.getTask());
        resultService.collectData(evaluationResult);
        EvaluationTaskDetailsResponse response = new EvaluationTaskDetailsResponse(evaluationResult.getResult());
        return response;
    }
}
