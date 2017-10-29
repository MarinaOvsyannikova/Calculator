package ru.ovsyannikova.calculator.domain.number.dao.impl;

import ru.ovsyannikova.calculator.domain.number.dao.NumberDAO;
import ru.ovsyannikova.calculator.domain.number.model.NumberCounter;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcNumberDAO implements NumberDAO{
    private DataSource dataSource;

    public JdbcNumberDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private List<NumberCounter> collectNumbers (ResultSet resultSet) throws SQLException {
        List<NumberCounter> list = new ArrayList<>();
        while (resultSet.next()) {
            NumberCounter numberCounter = new NumberCounter(
                    resultSet.getDouble("number"),
                    resultSet.getInt("amount")
            );
            numberCounter.setId(resultSet.getLong("id"));
            list.add(numberCounter);
        }
        return list;
    }

    @Override
    public List<NumberCounter> findMostPopular() throws SQLException {
        String sql = "SELECT * FROM numbers WHERE amount = (SELECT max(amount) FROM numbers)";
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                return collectNumbers(resultSet);
            }
        }
    }

    @Override
    public void upsert(NumberCounter numberCounter) throws SQLException {
        String sql = "MERGE INTO numbers USING (VALUES (CAST(? AS DECIMAL), CAST(? AS INTEGER)))" +
                "   AS vals(numb ,amount) ON numbers.number = vals.numb" +
                "   WHEN MATCHED THEN UPDATE SET numbers.amount = (numbers.amount + vals.amount)" +
                "   WHEN NOT MATCHED THEN INSERT VALUES (null, vals.numb, vals.amount)";
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setDouble(1, numberCounter.getNumber());
                statement.setLong(2, numberCounter.getAmount());
                statement.executeUpdate();
            }
        }
    }
}
