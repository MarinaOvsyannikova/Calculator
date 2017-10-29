package ru.ovsyannikova.calculator.domain;

import java.sql.SQLException;

@FunctionalInterface
public interface SupplierWithExceptions<T> {
    T get() throws SQLException;
}
