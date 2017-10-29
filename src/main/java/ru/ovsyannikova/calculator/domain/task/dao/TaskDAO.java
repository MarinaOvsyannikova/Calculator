package ru.ovsyannikova.calculator.domain.task.dao;

import ru.ovsyannikova.calculator.domain.task.model.Task;

import java.sql.SQLException;
import java.util.List;

public interface TaskDAO {
    void insert(Task task) throws SQLException;
    List<Task> findAllByCreated(String date) throws SQLException;

    Number countAllByCreated(String date) throws SQLException;

    Long countByRightParenthesisAmount() throws SQLException;
    Long countByLeftParenthesisAmount() throws SQLException;
    Long countByMultiplicationsAmount() throws SQLException;
    Long countBySubtractionsAmount() throws SQLException;
    Long countByDivisionsAmount() throws SQLException;
    Long countByAdditionsAmount() throws SQLException;
    Long countByPowersAmount() throws SQLException;

    List<Task> findByAdditionsAmount() throws SQLException;
    List<Task> findBySubtractionsAmount() throws SQLException;
    List<Task> findByPowersAmount() throws SQLException;
    List<Task> findByDivisionsAmount() throws SQLException;
    List<Task> findByMultiplicationsAmount() throws SQLException;
    List<Task> findByLeftParenthesisAmount() throws SQLException;
    List<Task> findByRightParenthesisAmount() throws SQLException;
}
