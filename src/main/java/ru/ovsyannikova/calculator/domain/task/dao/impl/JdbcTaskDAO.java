package ru.ovsyannikova.calculator.domain.task.dao.impl;

import ru.ovsyannikova.calculator.domain.task.dao.TaskDAO;
import ru.ovsyannikova.calculator.domain.task.model.Task;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTaskDAO implements TaskDAO {
    private DataSource dataSource;

    public JdbcTaskDAO(DataSource dataSource) throws NamingException {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Task task) throws SQLException {
        String sql = "INSERT INTO tasks (" +
                "task, " +
                "created," +
                "t_result," +
                "additionsAmount," +
                "subtractionsAmount," +
                "multiplicationsAmount," +
                "divisionsAmount," +
                "powersAmount," +
                "leftParenthesisAmount," +
                "rightParenthesisAmount) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, task.getTask());
                statement.setString(2, task.getCreated());
                statement.setDouble(3, task.getResult());
                statement.setInt(4, task.getAdditionsAmount());
                statement.setInt(5, task.getSubtractionsAmount());
                statement.setInt(6, task.getMultiplicationsAmount());
                statement.setInt(7, task.getDivisionsAmount());
                statement.setInt(8, task.getPowersAmount());
                statement.setInt(9, task.getLeftParenthesisAmount());
                statement.setInt(10, task.getRightParenthesisAmount());

                statement.executeUpdate();
            }
        }
    }

    private List<Task> collectTasks (ResultSet resultSet) throws SQLException {
        List<Task> taskList = new ArrayList<>();
        while (resultSet.next()) {
            Task task = new Task(
                    resultSet.getString("task"),
                    resultSet.getString("created"),
                    resultSet.getDouble("t_result"),
                    resultSet.getInt("additionsAmount"),
                    resultSet.getInt("subtractionsAmount"),
                    resultSet.getInt("multiplicationsAmount"),
                    resultSet.getInt("divisionsAmount"),
                    resultSet.getInt("powersAmount"),
                    resultSet.getInt("leftParenthesisAmount"),
                    resultSet.getInt("rightParenthesisAmount")
            );
            task.setId(resultSet.getLong("id"));
            taskList.add(task);
        }
        return taskList;
    }

    private Long returnCount(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return resultSet.getLong("rowcount");
        } else {
            return 0l;
        }
    }

    @Override
    public List<Task> findAllByCreated(String date) throws SQLException {
        String sql = "SELECT * FROM tasks WHERE created = ?";
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, date);
                ResultSet resultSet = statement.executeQuery();
                return collectTasks(resultSet);
            }
        }
    }

    @Override
    public Long countAllByCreated(String date) throws SQLException {
        String sql = "SELECT COUNT(*) AS rowcount FROM tasks WHERE created = ?";
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, date);
                ResultSet set = statement.executeQuery();
                return returnCount(set);
            }
        }
    }

    @Override
    public Long countByRightParenthesisAmount() throws SQLException {
        String sql = "SELECT COUNT(*) AS rowcount FROM tasks WHERE rightParenthesisAmount > 0";
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet set = statement.executeQuery(sql);
                return returnCount(set);
            }
        }
    }

    @Override
    public Long countByLeftParenthesisAmount() throws SQLException {
        String sql = "SELECT COUNT(*) AS rowcount FROM tasks WHERE leftParenthesisAmount > 0";
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                return returnCount(resultSet);
            }
        }
    }

    @Override
    public Long countByMultiplicationsAmount() throws SQLException {
        String sql = "SELECT COUNT(*) AS rowcount FROM tasks WHERE multiplicationsAmount > 0";
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet set = statement.executeQuery(sql);
                return returnCount(set);
            }
        }
    }

    @Override
    public Long countBySubtractionsAmount() throws SQLException {
        String sql = "SELECT COUNT(*) AS rowcount FROM tasks WHERE subtractionsAmount > 0";
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet set = statement.executeQuery(sql);
                return returnCount(set);
            }
        }
    }

    @Override
    public Long countByDivisionsAmount() throws SQLException {
        String sql = "SELECT COUNT(*) AS rowcount FROM tasks WHERE divisionsAmount > 0";
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet set = statement.executeQuery(sql);
                return returnCount(set);
            }
        }
    }

    @Override
    public Long countByAdditionsAmount() throws SQLException {
        String sql = "SELECT COUNT(*) AS rowcount FROM tasks WHERE additionsAmount > 0";
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet set = statement.executeQuery(sql);
                return returnCount(set);
            }
        }
    }

    @Override
    public Long countByPowersAmount() throws SQLException {
        String sql = "SELECT COUNT(*) AS rowcount FROM tasks WHERE powersAmount > 0";
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet set = statement.executeQuery(sql);
                return returnCount(set);
            }
        }
    }

    @Override
    public List<Task> findByAdditionsAmount() throws SQLException {
        String sql = "SELECT * FROM tasks WHERE additionsAmount > 0";
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                return collectTasks(resultSet);
            }
        }
    }

    @Override
    public List<Task> findBySubtractionsAmount() throws SQLException {
        String sql = "SELECT * FROM tasks WHERE subtractionsAmount > 0";
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                return collectTasks(resultSet);
            }
        }
    }

    @Override
    public List<Task> findByPowersAmount() throws SQLException {
        String sql = "SELECT * FROM tasks WHERE powersAmount > 0";
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                return collectTasks(resultSet);
            }
        }
    }

    @Override
    public List<Task> findByDivisionsAmount() throws SQLException {
        String sql = "SELECT * FROM tasks WHERE divisionsAmount > 0";
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                return collectTasks(resultSet);
            }
        }
    }

    @Override
    public List<Task> findByMultiplicationsAmount() throws SQLException {
        String sql = "SELECT * FROM tasks WHERE multiplicationsAmount > 0";
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                return collectTasks(resultSet);
            }
        }
    }

    @Override
    public List<Task> findByLeftParenthesisAmount() throws SQLException {
        String sql = "SELECT * FROM tasks WHERE leftParenthesisAmount > 0";
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                return collectTasks(resultSet);
            }
        }
    }

    @Override
    public List<Task> findByRightParenthesisAmount() throws SQLException {
        String sql = "SELECT * FROM tasks WHERE rightParenthesisAmount > 0";
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                return collectTasks(resultSet);
            }
        }
    }
}
