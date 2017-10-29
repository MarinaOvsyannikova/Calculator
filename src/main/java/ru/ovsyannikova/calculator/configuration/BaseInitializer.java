package ru.ovsyannikova.calculator.configuration;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseInitializer {

    public BaseInitializer() {
    }

    public void createTables(Connection connection) throws SQLException {
            String tasksTable =    "create TABLE tasks (" +
                    "id INTEGER IDENTITY PRIMARY KEY," +
                    "task VARCHAR(100) NOT NULL ," +
                    "created VARCHAR(10) NOT NULL ," +
                    "t_result DECIMAL NOT NULL ," +
                    "additionsAmount INTEGER NOT NULL ," +
                    "subtractionsAmount INTEGER NOT NULL ," +
                    "multiplicationsAmount INTEGER NOT NULL ," +
                    "divisionsAmount INTEGER NOT NULL ," +
                    "powersAmount INTEGER NOT NULL ," +
                    "leftParenthesisAmount INTEGER NOT NULL ," +
                    "rightParenthesisAmount INTEGER NOT NULL " +
                    ")";

            String numbersTable = "create TABLE numbers (" +
                    "id INTEGER IDENTITY PRIMARY KEY," +
                    "number DECIMAL NOT NULL ," +
                    "amount INTEGER NOT NULL" +
                    ")";
            try(Statement statement = connection.createStatement()) {
                statement.execute(tasksTable);
                statement.execute(numbersTable);
            }
    }
}
