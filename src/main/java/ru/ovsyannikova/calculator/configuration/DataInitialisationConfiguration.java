package ru.ovsyannikova.calculator.configuration;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class DataInitialisationConfiguration {
    @Bean
    InitializingBean prepareData(DataSource source) throws SQLException {
        return () -> {
            try(Connection connection = source.getConnection()) {
                    new BaseInitializer().createTables(connection);
            }
        };
    }
}