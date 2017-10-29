package ru.ovsyannikova.calculator.domain.number.dao;

import ru.ovsyannikova.calculator.domain.number.model.NumberCounter;

import java.sql.SQLException;
import java.util.List;

public interface NumberDAO {
    List<NumberCounter> findMostPopular() throws SQLException;
    void upsert(NumberCounter numberCounter) throws SQLException;
}
