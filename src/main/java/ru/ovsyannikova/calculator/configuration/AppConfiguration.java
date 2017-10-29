package ru.ovsyannikova.calculator.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class AppConfiguration {

    @Bean(destroyMethod = "")
    public DataSource dataSource() throws SQLException {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
        ds.setUrl("jdbc:hsqldb:mem:calcdb");
        ds.setUsername("SA");
        ds.setPassword("");
        ds.setInitialSize(5);
        return ds;
    }
}
