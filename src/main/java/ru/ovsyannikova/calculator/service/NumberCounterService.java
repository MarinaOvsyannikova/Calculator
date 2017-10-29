package ru.ovsyannikova.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ovsyannikova.calculator.domain.number.dao.NumberDAO;
import ru.ovsyannikova.calculator.domain.number.dao.impl.JdbcNumberDAO;
import ru.ovsyannikova.calculator.domain.number.model.NumberCounter;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Service
public class NumberCounterService {
    private DataSource dataSource;
    private NumberDAO numberDAO;

    @Autowired
    public NumberCounterService(DataSource dataSource) {
        this.dataSource = dataSource;
        numberDAO = new JdbcNumberDAO(dataSource);
    }

    public List<NumberCounter> getPopularNumber() throws SQLException {
        return numberDAO.findMostPopular();
    }

}
