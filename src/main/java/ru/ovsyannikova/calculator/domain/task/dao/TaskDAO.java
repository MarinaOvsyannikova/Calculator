package ru.ovsyannikova.calculator.domain.task.dao;

import ru.ovsyannikova.calculator.domain.task.model.Task;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface TaskDAO {
    void insert(Task task, Connection connection) throws SQLException;
    List<Task> findAllByCreated(String date) throws SQLException, ParseException;

    Number countAllByCreated(String date) throws SQLException, ParseException;

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
