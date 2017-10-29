package ru.ovsyannikova.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ovsyannikova.calculator.domain.number.dao.NumberDAO;
import ru.ovsyannikova.calculator.domain.number.dao.impl.JdbcNumberDAO;
import ru.ovsyannikova.calculator.domain.number.model.NumberCounter;
import ru.ovsyannikova.calculator.domain.task.dao.TaskDAO;
import ru.ovsyannikova.calculator.domain.task.dao.impl.JdbcTaskDAO;
import ru.ovsyannikova.calculator.domain.task.model.Task;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class EvaluationResultService {
    private DataSource dataSource;
    private TaskDAO taskDAO;
    private NumberDAO numberDAO;

    @Autowired
    public EvaluationResultService(DataSource dataSource) throws NamingException {
        this.dataSource = dataSource;
        taskDAO = new JdbcTaskDAO(dataSource);
        numberDAO = new JdbcNumberDAO(dataSource);
    }


    public void collectData(EvaluationResult evaluationResult) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            try {
                saveTask(evaluationResult, connection);
                collectNumbersAmounts(evaluationResult, connection);
                connection.commit();
            } catch (SQLException ex) {
                connection.rollback();
            } finally {
                connection.setAutoCommit(true);
            }
        }

    }

    public void saveTask(EvaluationResult evaluationResult, Connection connection) throws SQLException {
        OffsetDateTime time = OffsetDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String resultDate = time.format(formatter);

        Task task = new Task(evaluationResult.getTask(), resultDate, evaluationResult.getResult(),
                evaluationResult.getOperationAmounts().get("+"),
                evaluationResult.getOperationAmounts().get("-"),
                evaluationResult.getOperationAmounts().get("*"),
                evaluationResult.getOperationAmounts().get("/"),
                evaluationResult.getOperationAmounts().get("^"),
                evaluationResult.getOperationAmounts().get("("),
                evaluationResult.getOperationAmounts().get(")")
                );
        taskDAO.insert(task, connection);
    }

    private void collectNumbersAmounts(EvaluationResult evaluationResult, Connection connection) throws SQLException {
        HashMap<Double, Integer> numberAmounts = evaluationResult.getNumberAmounts();
        Set<Map.Entry<Double, Integer>> entries = numberAmounts.entrySet();
        for (Map.Entry<Double, Integer> elem: entries) {
            NumberCounter numberCounter = new NumberCounter(elem.getKey(), elem.getValue());
            numberDAO.upsert(numberCounter, connection);
        }
    }



}
