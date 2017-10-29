package ru.ovsyannikova.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ovsyannikova.calculator.domain.SupplierWithExceptions;
import ru.ovsyannikova.calculator.domain.task.dao.TaskDAO;
import ru.ovsyannikova.calculator.domain.task.dao.impl.JdbcTaskDAO;
import ru.ovsyannikova.calculator.domain.task.model.Task;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Service
public class EvaluationTaskService {
    private DataSource dataSource;
    private Evaluator evaluator;
    private TaskDAO taskDAO;

    private HashMap<String, SupplierWithExceptions<List<Task>>> findMethodsByOperation;
    private HashMap<String, SupplierWithExceptions<Long>> countMethodsByOperation;

    @Autowired
    public EvaluationTaskService(Evaluator evaluator, DataSource dataSource) throws NamingException {
        this.dataSource = dataSource;
        this.taskDAO = new JdbcTaskDAO(dataSource);
        this.evaluator = evaluator;

        findMethodsByOperation = new HashMap<>();
        findMethodsByOperation.put("+", taskDAO::findByAdditionsAmount);
        findMethodsByOperation.put("-", taskDAO::findBySubtractionsAmount);
        findMethodsByOperation.put("*", taskDAO::findByMultiplicationsAmount);
        findMethodsByOperation.put("/", taskDAO::findByDivisionsAmount);
        findMethodsByOperation.put("^", taskDAO::findByPowersAmount);
        findMethodsByOperation.put("(", taskDAO::findByLeftParenthesisAmount);
        findMethodsByOperation.put(")", taskDAO::findByRightParenthesisAmount);

        countMethodsByOperation = new HashMap<>();
        countMethodsByOperation.put("+", taskDAO::countByAdditionsAmount);
        countMethodsByOperation.put("-", taskDAO::countBySubtractionsAmount);
        countMethodsByOperation.put("*", taskDAO::countByMultiplicationsAmount);
        countMethodsByOperation.put("/", taskDAO::countByDivisionsAmount);
        countMethodsByOperation.put("^", taskDAO::countByPowersAmount);
        countMethodsByOperation.put("(", taskDAO::countByLeftParenthesisAmount);
        countMethodsByOperation.put(")", taskDAO::countByRightParenthesisAmount);
    }

    public EvaluationResult evaluate(String task) throws IOException {
        try{
            return evaluator.getResult(task);
        } catch (IOException ex) {
            throw new IllegalArgumentException("Wrong expression for evaluation: " + task);
        }
    }

    public Number countTasksByDate(String date) throws SQLException {
        return taskDAO.countAllByCreated(date);
    }

    public Iterable<Task> findAllByDate(String date) throws SQLException {
        return taskDAO.findAllByCreated(date);
    }



    public Long countTasksByOperation(String operation) throws SQLException {
        return countMethodsByOperation.get(operation).get();
    }

    public Iterable<Task> findTasksByOperation(String operation) throws SQLException {

        return findMethodsByOperation.get(operation).get();
    }
}
