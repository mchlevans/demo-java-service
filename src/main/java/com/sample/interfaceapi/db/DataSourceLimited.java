package com.autos.api.db;

import java.util.logging.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ConnectionBuilder;
import java.sql.SQLFeatureNotSupportedException;
import java.io.PrintWriter;

public class DataSourceLimited implements DataSource {

    private DataSource datasource;

    public DataSourceLimited(DataSource datasource) {
        this.datasource = datasource;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return datasource.isWrapperFor(iface);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return datasource.unwrap(iface);
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return datasource.getParentLogger();
    }

    @Override
    public ConnectionBuilder createConnectionBuilder() throws SQLException {
        return datasource.createConnectionBuilder();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return datasource.getConnection(username, password);
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return datasource.getLogWriter();
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        datasource.setLogWriter(out);
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        datasource.setLoginTimeout(seconds);
    };

    @Override
    public int getLoginTimeout() throws SQLException {
        return datasource.getLoginTimeout();
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = datasource.getConnection();
        
        // auto commit must be false for setFetchSize to be implemented
        connection.setAutoCommit(false);
        
        return connection;
    }
}

